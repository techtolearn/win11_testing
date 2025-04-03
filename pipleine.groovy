pipline {
    stage any
    environment {
        WINDOW_CACHE = "${WORKSPACE}/m2"
    }
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://repot.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn build -Dmaven.repo.local=$WINDOW_CACHE'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dmaven.repo.local=$WINDOW_CACHE'
            }
        }
        stage('Build') {
            steps {
                sh 'kubectl -f apply deploy.yml'
            }
        }
    }

}
