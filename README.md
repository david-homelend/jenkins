# jenkins-demo
* Prepare and run: <br/>

  * <code>cd jenkins-demo</code>
  * <code>docker-compose build</code>
  * <code>docker-compose up -d</code>

* Selenium python package is installed as part of the docker-build (you can find it and adjust/add some more packages by updating the Dockerfile, note that you'll need to run docker-compose build and restart the container.)<br/>
* The selenium_simple.py is mounted from the host, hence you can update it on the host andthe changes will be reflected inside the container as well.
* In order to grab the initial password:<br/>
  <code>
  docker exec my-jenkins-3 bash -c "cat /var/jenkins_home/secrets/initialAdminPassword"
  </code>

* Initial/simple pipeline can be found at the pipeline.groovy file
