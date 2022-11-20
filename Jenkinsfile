 @Library('jenkins-shared-library')
 def gv 

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
    stage('init') {
      steps {
        script {
          gv = load "external-script.groovy"
        }
      }
    }
    stage ('Build') {
      when {
        expression {
          params.VERSION == '1.0'
        }
      }
      steps {
        script {
        buildApp()
      }
      } 
    }
    stage ('Test') {
      steps {
        script {
          testApp()
        }
      }
    }
    stage ('deploy') {
      input {
        message "Select which staging environment"
        parameters {
          choice(name: 'stage', choices: ['prod', 'uat'])
        }
      }
      steps {
        script {
          gv.deployApp(env.stage)
          
        }
      }
    }
  }
}