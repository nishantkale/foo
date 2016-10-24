package mongo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Scanner;

public class Mongo{
    public static void main(String args[]) throws UnknownHostException {

            Scanner in = new Scanner(System.in);
            int ch;
            do{
                System.out.println("Select:\n1)Insert\n2)Update\n3)Find\n4)Remove\n5)Exit");
                ch=in.nextInt();
                switch (ch){
                    case 1:
                        int no,marks;
                        String name,grade;
                        System.out.println("Enter the No:");
                        no=in.nextInt();
                        System.out.println("Enter the Name:");
                        name=in.next();
                        System.out.println("Enter the Marks:");
                        marks=in.nextInt();
                        System.out.println("Enter the Grade:");
                        grade=in.next();
                        BasicDBObject dboin= new BasicDBObject("No",no).append("Name",name).append("Marks",marks).append("Grade",grade);
                        MongoClient mcin= null;
                        try {
                            mcin = new MongoClient("localhost",27017);
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }
                        DB dbin=mcin.getDB("workspace");
                        DBCollection colin=dbin.getCollection("test");
                        colin.insert(dboin);
                        break;
                    case 2:
                        String gradeup;
                        int noup;
                        System.out.println("Enter the No:");
                        noup=in.nextInt();
                        System.out.println("Enter the Grade:");
                        gradeup=in.next();
                        BasicDBObject dboupdata= new BasicDBObject();
                        dboupdata.append("$set",new BasicDBObject().append("Grade",gradeup));
                        BasicDBObject dboupcriteria=new BasicDBObject().append("No",noup);

                        MongoClient mcup= null;
                        try {
                            mcup = new MongoClient("localhost",27017);
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }
                        DB dbup=mcup.getDB("workspace");
                        DBCollection colup=dbup.getCollection("test");
                        colup.update(dboupcriteria,dboupdata);
                        break;
                    case 3:
                        try {
                            MongoClient mc=new MongoClient("localhost",27017);
                            DB db=mc.getDB("workspace");
                            DBCollection col=db.getCollection("test");
                            System.out.println("Count: "+col.getCount());
                            DBCursor cur=col.find();

                            while (cur.hasNext()){
                                System.out.println(cur.next());
                            }
                            cur.close();
                        } catch (UnknownHostException e) {e.printStackTrace();}
                        break;
                    case 4:
                        System.out.println("Enter the No:");
                        int nor=in.nextInt();
                        MongoClient mcr=new MongoClient("localhost",27017);
                        DB dbr=mcr.getDB("workspace");
                        DBCollection colr=dbr.getCollection("test");
                        System.out.println("Count: " + colr.getCount());
                        BasicDBObject dbor= new BasicDBObject("No",nor);
                        colr.remove(dbor);
                        break;
                    case 5:
                        System.out.println("Exit...");
                    }
                }while (ch<5);


    }
}
