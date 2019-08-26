def call() {
  Map pipelineCfg = readYaml(file: "/var/lib/jenkins/workspace/${JOB_NAME}/pipeline.yaml")
  return pipelineCfg
}
