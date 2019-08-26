def call() {
  sh "pwd"
  sh "ls"
  Map pipelineCfg = readYaml(file: "${workspace}/develop_pipeline/pipeline.yaml")
  return pipelineCfg
}
