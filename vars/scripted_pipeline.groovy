def func() {
  println "func()"
}

def call(Map params) {
  node {
    stage('Outer Stage 1') {
      println "Outer Stage 1"
      println params.get("param1")
      func()
      ci.sharedFunc()
    }
    stage('Outer Stage 2') {
      stage('Inner Stage 1') {
        println "Inner Stage 1"
        println params.get("param2")
        lib = library("cilib")
        println lib
        lib.ci.sharedFunc()
      }
    }
  }
}
