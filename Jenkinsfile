pipeline {
    agent any

    environment {
        IMAGE_NAME = "trader-tests"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/LazyBoy8606/MyAutomation.git'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                echo "Starting Selenium Grid..."
                sh 'docker compose down || true'
                sh 'docker compose up -d'
            }
        }

        stage('Build Test Image') {
            steps {
                echo "Building Docker image for automation project..."
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Run Tests Inside Docker') {
            steps {
                echo "Executing Cucumber tests using Docker image..."
                sh "docker run --network=host -v $WORKSPACE/Reports:/app/Reports ${IMAGE_NAME}"
            }
        }

        stage('Publish Reports') {
            steps {
                echo "Publishing HTML Automation Report..."
                publishHTML(target: [
                    reportDir: 'Reports/SparkReport',
                    reportFiles: 'index.html',
                    reportName: 'Cucumber Test Report',
                    allowMissing: true
                ])
            }
        }
    }

    post {
        always {
            echo "Cleaning up Selenium Grid containers..."
            sh 'docker compose down || true'
        }
    }
}
