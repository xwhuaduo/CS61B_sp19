public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public static final double gg = 6.67e-11;

	/** Constructors */
	public Body(double xP, double yP, double xV,
				double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Second constructors */
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/** Method to calculate distance. */
	public double calcDistance(Body b) {
		double xxDif = this.xxPos - b.xxPos;
		double yyDif = this.yyPos - b.yyPos;
		return Math.sqrt(xxDif*xxDif + yyDif*yyDif);
	}

	/** Method to calculate force exerted on give Body. */
	public double calcForceExertedBy(Body b) {
		double rr = this.calcDistance(b);
		double force = gg * this.mass * b.mass/Math.pow(rr,2);
		return force;
	}

	/** Method to calculate net force on x-axis. */
	public double calcForceExertedByX(Body b) {
		double force = this.calcForceExertedBy(b);
		double rr = this.calcDistance(b);
		double xxDif = b.xxPos - this.xxPos;
		double forceX = force * xxDif / rr;

		return forceX;
	}


	/** Method to calculate net force on y-axis. */
	public double calcForceExertedByY(Body b) {
		double force = this.calcForceExertedBy(b);
		double rr = this.calcDistance(b);
		double yyDif = b.yyPos - this.yyPos;
		double forceY = force * yyDif / rr;

		return forceY;
	}

	/** Method to calculate net force on x-axis exerted by one or more objects. */
	public double calcNetForceExertedByX(Body[] bs) {
		double forceX = 0;
		for (Body b: bs) {
			if (this.equals(b)) {

			} else {
				forceX += this.calcForceExertedByX(b);
			}
		}
		return forceX;
	}

	/** Method to calculate net force on y-axis exerted by one or more objects. */
	public double calcNetForceExertedByY(Body[] bs) {
		double forceY = 0;
		for (Body b: bs) {
			if (this.equals(b)) {

			} else {
				forceY += this.calcForceExertedByY(b);
			}
		}
		return forceY;
	}

	/** Method to update body. */
	public void update(double t, double fx, double fy) {
		double xxA = fx / this.mass;
		double yyA = fy / this.mass;
		this.xxVel = this.xxVel + t*xxA;
		this.yyVel = this.yyVel + t*yyA;
		this.xxPos = this.xxPos + this.xxVel * t;
		this.yyPos = this.yyPos + this.yyVel * t;
	}

}