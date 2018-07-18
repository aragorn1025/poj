package poj.no3669.wa;

import java.util.Scanner;

public class Main {
	private static Scanner		scanner	= new Scanner(System.in);

	// constants
	private static final int[]	dx		= { 0, 1, 0, -1, 0 };
	private static final int[]	dy		= { 0, 0, 1, 0, -1 };

	// data
	private static Queue		queue	= new Queue(Math.max(Point.MAP_WIDTH, Point.MAP_HEIGHT));
	private static int[][]		maps;
	private static int			output;

	public static void main(String[] args) {
		// inputs
		int m = scanner.nextInt();
		maps = new int[Point.MAP_HEIGHT][Point.MAP_WIDTH];
		for (int i = 0; i < Point.MAP_HEIGHT; i++) {
			for (int j = 0; j < Point.MAP_WIDTH; j++) {
				maps[i][j] = Point.MAX_TIME * 2;
			}
		}
		int x, y, nx, ny, t;
		while (m > 0) {
			m--;
			x = scanner.nextInt();
			y = scanner.nextInt();
			t = scanner.nextInt();
			for (int i = 0; i < 5; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx >= 0 && nx < Point.MAP_WIDTH && ny >= 0 && ny < Point.MAP_HEIGHT) {
					maps[nx][ny] = Math.min(maps[nx][ny], t);
				}
			}
		}

		// output
		if (maps[0][0] > Point.MAX_TIME) {
			output = 0;
		} else {
			queue.offer(new Point(0, 0, 0));
			breadthFirstSearch();
		}
		System.out.printf("%d\n", output);
	}

	private static void breadthFirstSearch() {
		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			if (temp.t < 0 || temp.t >= Point.MAX_TIME) {
				output = -1;
			} else {
				for (int i = 1; i < 5; i++) {
					if (temp.x + dx[i] < 0 || temp.x + dx[i] >= Point.MAP_WIDTH || temp.y + dy[i] < 0 || temp.y + dy[i] >= Point.MAP_HEIGHT) {
						continue;
					}
					if (maps[temp.x + dx[i]][temp.y + dy[i]] > Point.MAX_TIME) {
						output = temp.t + 1;
						return;
					} else if (maps[temp.x + dx[i]][temp.y + dy[i]] > temp.t + 1) {
						queue.offer(new Point(temp.x + dx[i], temp.y + dy[i], temp.t + 1));
					}
				}
			}
		}
		output = -1;
	}
}

class Point {
	public static final int	MAP_WIDTH	= 300;
	public static final int	MAP_HEIGHT	= 300;
	public static final int	MAX_TIME	= MAP_WIDTH * MAP_HEIGHT;

	public int				x;
	public int				y;
	public int				t;

	public Point(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}

	@Override
	public int hashCode() {
		int returnValue = t;
		returnValue = returnValue * (MAP_WIDTH + 1) + x;
		returnValue = returnValue * (MAP_HEIGHT + 1) + y;
		return returnValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		if (t != other.t) {
			return false;
		}
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
}

class Queue {
	private int		front;
	private int		rear;
	private Point[]	points;

	public Queue(int size) {
		points = new Point[size];
		clear();
	}

	public void clear() {
		front = size() - 1;
		rear = size() - 1;
	}

	public boolean contains(Object object) {
		if (object == null) {
			return false;
		} else if (new Point(0, 0, 0).getClass() != object.getClass()) {
			return false;
		} else {
			if (isEmpty()) {
				return false;
			}

			Point other = (Point) object;
			if (rear > front) {
				for (int i = front + 1; i <= rear; i++) {
					if (points[i].equals(other)) {
						return true;
					}
				}
			} else if (rear == front) {
				// queue is empty
			} else {
				for (int i = 0; i <= rear; i++) {
					if (points[i].equals(other)) {
						return true;
					}
				}
				for (int i = front + 1; i < size(); i++) {
					if (points[i].equals(other)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return front == (rear + 1) % size();
	}

	public int size() {
		return points.length;
	}

	public boolean offer(Point point) {
		if (isFull()) {
			return false;
		} else if (contains(point)) {
			return false;
		} else {
			rear = (rear + 1) % size();
			points[rear] = point;
			return true;
		}
	}

	public Point peek() {
		if (isEmpty()) {
			return null;
		} else {
			return points[(front + 1) % size()];
		}
	}

	public Point poll() {
		if (isEmpty()) {
			return null;
		} else {
			front = (front + 1) % size();
			return points[front];
		}
	}
}