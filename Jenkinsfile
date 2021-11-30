pipeline {

	agent any
	
	stages{
		stage('Compile Stage'){
				steps{
					withMaven(maven : 'Maven Installations'){
							bat 'mvn clean test'
						}
					}
				}
		stage('Testing Stage'){
				steps{
					withMaven(maven : 'Maven Installations'){
							bat 'allure serve target/allure-results'
						}
					}
				}
			}
		}
