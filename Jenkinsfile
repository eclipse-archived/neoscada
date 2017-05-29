pipeline {
    agent any

    stages {
        stage('Build') {
			steps {
				withMaven(
			        maven: 'M3',
				    )
 				sh "mvn clean install"
 			}
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}