public class NBody{
  public static double readRadius(String dict){
    In in=new In(dict);
    int num=in.readInt();
    double Radius=in.readDouble();
    return Radius;
  }
  public static Planet[] readPlanets(String dict){
    Planet[] Planet_list=new Planet[5];
    In in=new In(dict);
    int num=in.readInt();
    double Radius=in.readDouble();
    for(int i=0;i<5;i+=1){
      double xPos=in.readDouble();
      double yPos=in.readDouble();
      double xVel=in.readDouble();
      double yVel=in.readDouble();
      double mass=in.readDouble();
      String img=in.readString();
      Planet_list[i]=new Planet(xPos,yPos,xVel,yVel,mass,img);
    }
    return Planet_list;
  }
  public static void main(String[] args) {
    double T=Double.parseDouble(args[0]);
    double dt=Double.parseDouble(args[1]);
    String filename=args[2];
    double radius=readRadius(filename);
    Planet[] Planet_list=readPlanets(filename);
    StdDraw.setScale(-radius, radius);
    StdDraw.clear();
    StdDraw.picture(0, 0, "images/starfield.jpg");
    for(Planet p:Planet_list){
      p.draw();
    }
    StdDraw.enableDoubleBuffering();
    for(double t=0;t<=T;t+=dt){
      double[] xForces= new double[5];
      double[] yForces= new double[5];
      for(int i=0;i<5;i+=1){
        xForces[i]=Planet_list[i].calcNetForceExertedByX(Planet_list);
        yForces[i]=Planet_list[i].calcNetForceExertedByY(Planet_list);
        Planet_list[i].update(dt,xForces[i],yForces[i]);
      }
       StdDraw.picture(0, 0, "images/starfield.jpg");
       for(Planet p:Planet_list){
         p.draw();
       }
       StdDraw.show();
       StdDraw.pause(10);
   }
   }

}
