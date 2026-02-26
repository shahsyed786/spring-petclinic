pipeline {
  agent any

  triggers {
    // every 5 minutes on Thursday
    cron('H/5 * * * 4')
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test + JaCoCo') {
      steps {
        sh 'mvn -B test jacoco:report'
      }
      post {
        always {
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
          junit 'target/surefire-reports/*.xml'
          publishHTML(target: [
            allowMissing: false,
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
}
