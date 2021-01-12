def func() {
  println "func()"
}

def call(Map params) {
    pipeline {
        agent any
        options {
            timeout(time: 1, unit: 'HOURS')
        }
        stages {
            stage('Outer Stage 1') {
                steps {
                  println "Outer Stage 1"
                  println params.get("param1")
                }
            }
            stage('Outer Stage 2') {
                stages {
                    stage('Inner Stage 1') {
                        steps {
                            println "Inner Stage 1"
                            println params.get("param2")
                        }
                    }
                }
            }
        }
    }
}
