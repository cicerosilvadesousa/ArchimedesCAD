package br.org.archimedes.trim.line;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import br.org.archimedes.exceptions.NullArgumentException;
import br.org.archimedes.interfaces.IntersectionManager;
import br.org.archimedes.line.Line;
import br.org.archimedes.model.ComparablePoint;
import br.org.archimedes.model.DoubleKey;
import br.org.archimedes.model.Element;
import br.org.archimedes.model.Point;
import br.org.archimedes.model.Vector;
import br.org.archimedes.rcp.extensionpoints.IntersectionManagerEPLoader;
import br.org.archimedes.trims.interfaces.Trimmer;

public class LineTrimmer implements Trimmer {
	private IntersectionManager intersectionManager;

	public LineTrimmer() {
		intersectionManager = new IntersectionManagerEPLoader()
				.getIntersectionManager();
	}

	public Collection<Element> trim(Element element,
			Collection<Element> references, Point click)
			throws NullArgumentException {

		if (element == null || references == null) {
			throw new NullArgumentException();
		}

		Line line = (Line) element;
		Collection<Element> trimResult = new ArrayList<Element>();
		SortedSet<ComparablePoint> sortedPointSet = getSortedPointSet(line,
				line.getInitialPoint(), intersectionManager
						.getIntersectionsBetween(line, references));

		Vector direction = new Vector(line.getInitialPoint(), line
				.getEndingPoint());
		Vector clickVector = new Vector(line.getInitialPoint(), click);
		double key = direction.dotProduct(clickVector);
		ComparablePoint clickPoint = null;
		try {
			clickPoint = new ComparablePoint(click, new DoubleKey(key));
		} catch (NullArgumentException e) {
			// Should never reach
			e.printStackTrace();
		}

		SortedSet<ComparablePoint> headSet = sortedPointSet.headSet(clickPoint);
		SortedSet<ComparablePoint> tailSet = sortedPointSet.tailSet(clickPoint);

		try {
			if (headSet.size() == 0 && tailSet.size() > 0) {
				Element trimmedLine = new Line(tailSet.first().getPoint(), line
						.getEndingPoint());
				trimmedLine.setLayer(line.getLayer());

				trimResult.add(trimmedLine);
			} else if (tailSet.size() == 0 && headSet.size() > 0) {
				Element trimmedLine = new Line(line.getInitialPoint(), headSet
						.last().getPoint());
				trimmedLine.setLayer(line.getLayer());

				trimResult.add(trimmedLine);
			} else if (headSet.size() > 0 && tailSet.size() > 0) {
				Element trimmedLine1 = new Line(line.getInitialPoint(), headSet
						.last().getPoint());
				trimmedLine1.setLayer(line.getLayer());
				trimResult.add(trimmedLine1);

				if (!tailSet.first().getPoint().equals(line.getEndingPoint())) {
					Element trimmedLine2 = new Line(tailSet.first().getPoint(),
							line.getEndingPoint());
					trimmedLine2.setLayer(line.getLayer());
					trimResult.add(trimmedLine2);
				}
			}
		} catch (Exception e) {
			// Should not catch any exception
			e.printStackTrace();
		}

		return trimResult;
	}

	public SortedSet<ComparablePoint> getSortedPointSet(Line line,
			Point referencePoint, Collection<Point> intersectionPoints) {

		SortedSet<ComparablePoint> sortedPointSet = new TreeSet<ComparablePoint>();

		Point otherPoint = line.getInitialPoint();
		if (referencePoint.equals(line.getInitialPoint())) {
			otherPoint = line.getEndingPoint();
		}

		Vector direction = new Vector(referencePoint, otherPoint);
		for (Point point : intersectionPoints) {
			Vector pointVector = new Vector(referencePoint, point);
			double key = direction.dotProduct(pointVector);
			ComparablePoint element;
			try {
				element = new ComparablePoint(point, new DoubleKey(key));
				sortedPointSet.add(element);
			} catch (NullArgumentException e) {
				// Should never reach
				e.printStackTrace();
			}
		}

		return sortedPointSet;
	}
}