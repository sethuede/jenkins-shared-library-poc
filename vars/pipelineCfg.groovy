def call() {

  Map pipelineCfg = readYaml(file: "/var/lib/jenkins/workspace/${JOB_NAME}/pipeline.yaml")
  sh "pwd"
  sh "ls"
  return pipelineCfg
}
