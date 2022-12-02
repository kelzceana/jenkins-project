#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    def dockerCmd = 'docker run -p 3000:3080 kelzceana/web-app:1.0'
                        sshagent(['EC2-server-key']) {
                            // some block
                            sh "ssh -o StrictHostKeyChecking=no ec2-user@54.166.104.195 ${dockerCmd}"
                                }
                }
            }
        }
}
}
