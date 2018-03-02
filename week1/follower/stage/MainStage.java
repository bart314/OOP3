package follower.stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import com.sun.javafx.geom.Vec2d;

import follower.components.Boid;
import follower.components.MouseFollower;
import follower.util.ExtPoint2D;
import follower.util.Settings;


public class MainStage extends Application {
	private Timer timer=new Timer();
	private ArrayList<Boid> boids = new ArrayList<Boid>();
	private MouseFollower handler;
	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 1200, 800);
		scatter(root);
		
		handler = new MouseFollower(this);				
		scene.addEventHandler(MouseEvent.MOUSE_MOVED, handler);

		stage.setScene(scene);
		stage.show();
		
		Timeline t1 = new Timeline();
		t1.setCycleCount(Animation.INDEFINITE);
		KeyFrame k1 = new KeyFrame(
				Duration.millis(50),
				s->updateBoids()
			);
		
		t1.getKeyFrames().add(k1);
		t1.play();
	}
	
	public void updateBoids() {
		final Vec2d following = handler.getMouseCoords();
		
		//Example
		int total = IntStream.range(0, boids.size())
		  .sum();
		
		
		/* iterative */
//		for (Boid follower: boids) {
//			follower.update(following);
//			following = follower.getPosition();
//		}
		
		/* met lambda's, maar dan fout */
		/*
		boids.forEach( boid -> {
			boid.update(following);
			following = boid.getPosition();
		});
		*/
		
		/* met lambda's, maar dan goed */
		
		IntStream.range(0, boids.size()).forEach(nr -> {
			if (nr==0) boids.get(0).update(following);
			else boids.get(nr).update(boids.get(nr-1).getPosition());
		});
		
		// TODO
		// Using the example above, replace the foreach loop below
		// with a more Java 8 like alternative. 
		// Hint 1: remember that everyhing that is put in a lambda expression
		//         works as a 'closure'; so is it possible to redefine the 
		//         parameter 'following' in the way below...?
		// Hint 2: We have added a field 'boidnumber' in the Boid class.
	}
	
	
	private void scatter(Group target) {
		Random random = new Random();
		
		// example for the exercise below.
		List<String> foo = IntStream.range(0, Settings.NUM_OF_BOIDS)
				.boxed()
				.map(s->"Number "+s)
				.collect(Collectors.toList());
		System.out.println(foo);
		
		
		// TODO
		// use the example above to change the for-loop below into a 
		// more Java 8 format. 
		// hint 1: there is no Collectors.toArrayList, so use a cast to
		//         ArrayList<Boid>.
		// hint 2: look at the Boid class. We have made a BoidBuilder inner
		//         class; for extra credits, you can use this instead of 
		//         setting the properties directly.
		
		for (int i=0; i<=Settings.NUM_OF_BOIDS; i++) {
			double randomX = Settings.STAGE_WIDTH*random.nextDouble();
			double randomY = Settings.STAGE_HEIGHT*random.nextDouble();

			Boid b = new Boid();
			b.setPosition(new ExtPoint2D(randomX, randomY));
			b.setHeading(new ExtPoint2D(random.nextFloat(), random.nextFloat()));
			boids.add(b);
			target.getChildren().add(b.getContent());
		}
	}
		
	
	public Boid getFirstBoid() {
		return boids.get(0);
	}
	
	public void stop() {
		timer.cancel();
	}
	
	
	public static void main (String[] args) {
		launch (args);
	}
}