pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                withMaven(maven: 'maven_3_6_3') {
                    script {
                        if (env.UNIT_TESTS) {
                            sh 'mvn clean install'
                        } else {
                            sh 'mvn clean install -DskipTests'
                        }
                    }
                }
            }
        }
    }
}
