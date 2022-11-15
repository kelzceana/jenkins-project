pipeline {
  agent any
  tools {
    maven 'maven3'
  }
  parameters {
    choice(name: "VERSION", choices: ['1.0', '1.1', '1.2'], description: "")
    booleanParam(name: "executeTests", defaultValue: true, description: "")
  }
  stages {
    stage ('Build') {
      when {
        expression {
          params.choices = '1.0'
        }
      }
      steps {
        echo 'This is the build phase'
      } 
    }
    stage ('Test') {
      steps {
        echo 'This is the testing phase'
      }
    }
    stage ('deploy') {
      steps {
        echo 'This is the deployment phase'
      }
    }
  }
}