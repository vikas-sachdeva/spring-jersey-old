package spring.jsample.spark.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spark.Spark;
import spring.jsample.beans.HelloWorld;
import spring.jsample.spark.SparkResource;

@Component
public class AppRoutes implements SparkResource {

	@Autowired
	private HelloWorld helloWorld;

	@Override
	public void register() {

		Spark.path("/rest", () -> {

			Spark.get("/hello/:name", (req, res) -> {
				helloWorld.setName(req.params("name"));
				return helloWorld.getMsg();
			});
		});
	}

}
