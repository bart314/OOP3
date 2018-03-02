package follower.components;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public interface Drawable {
	public Node getContent();
	public void setPosition(Point2D position);
	public Point2D getPosition();

}
