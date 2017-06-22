pipeline {
	agent any

	tools {
		maven 'apache-maven-latest'
	}
	
	stages {
		stage('Build') {
			steps {
				sh 'mvn clean'
				sh 'MAVEN_OPTS="-Xms1024m -Xmx3072m -XX:PermSize=512m" mvn -Dmaven.test.failure.ignore=true install'
			}
		}
		stage('Archive') {
			steps {
				archive '**/*-p2/target/*p2-*.zip'
				archive '**/*-product/target/products/*.tar.gz'
				archive '**/*-product/target/products/*.zip'
				archive '**/*-p2/target/*p2-*.deb'
				archive '**/*-p2/target/*p2-*.rpm'
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploying....'
			}
		}
	}
}