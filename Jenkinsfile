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
        bat 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test + JaCoCo') {
      steps {
        bat 'mvn -B test jacoco:report'
      }
      post {
        always {
          // Petclinic often produces a .war; archive both just in case
          archiveArtifacts artifacts: 'target/*.war, target/*.jar', fingerprint: true
          junit 'target/surefire-reports/*.xml'
          publishHTML(target: [
            allowMissing: true,              // avoid failing if report folder missing
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
