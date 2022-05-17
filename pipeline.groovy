pipeline {
    agent { label 'agent_1' }
    stages {
        stage('Build docker image'){
            steps{
                sh 'docker build -t moditamam/selenium:from-jenkins-pipeline .'
                sh 'docker login -u moditamam -p @Mbmt123456'
                sh 'docker push moditamam/selenium:from-jenkins-pipeline'
                sh 'docker rmi moditamam/selenium:from-jenkins-pipeline'
            }
        }
        stage('list files') {
            agent {
                docker {
                    image "moditamam/selenium:from-jenkins-pipeline"
                    reuseNode true
                }
            }
            steps {
                sh 'python3.9 selenium_simple.py'
            }
        }
    }
}