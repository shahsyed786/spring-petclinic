pipeline {
  agent any

  triggers {
    // every 5 minutes on Thursday
    cron('H/5 * * * 4')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        bat 'mvnw.cmd -B -DskipTests clean package'
      }
    }

    stage('Test + JaCoCo') {
      steps {
        bat 'mvnw.cmd -B test jacoco:report'
      }
      post {
        always {
          archiveArtifacts artifacts: 'target/*.war, target/*.jar', fingerprint: true
          junit 'target/surefire-reports/*.xml'
          publishHTML(target: [
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'target/site/jacoco',
            reportFiles: 'index.html',
            reportName: 'JaCoCo Coverage Report'
          ])
        }
      }
    }
  }

  post {
    always {
      echo 'Pipeline finished.'
    }
  }
}
