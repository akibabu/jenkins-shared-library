package jp.akibabu

public class Ci {
  def checkout() {
    checkout([
      $class: 'GitSCM',
      branches: scm.branches,
      extensions: scm.extensions + [
        [$class: 'CloneOption', noTags: false, reference: '', shallow: false],
        [$class: 'SubmoduleOption', disableSubmodules: false, parentCredentials: true, recursiveSubmodules: true, reference: '', trackingSubmodules: false],
      ],
      userRemoteConfigs: scm.userRemoteConfigs
    ])
  }
  
  def prepareEnv() {
    println "prepareEnv()"
  }
}
