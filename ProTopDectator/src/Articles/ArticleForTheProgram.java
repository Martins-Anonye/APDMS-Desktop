/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articles;

import DataModel.CategoryModel.CategoryModeling;
import WebviewDisplay.webContentsDisplay;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import protopdectator.AllStaticVariable;
import static protopdectator.AllStaticVariable.pri;
import protopdectator.ProTopDectator;

/**
 *
 * @author user
 */
public class ArticleForTheProgram extends ProTopDectator implements AllStaticVariable{
    
   static  Button howtoupadet = new Button("How to Update");
              static  Button howtoupadetcat = new Button("How to Update Category");

            static  Button howtodelet = new Button("How to Delete");
                        static  Button howtodeletcat = new Button("How to Delete Category");

      static       Button addnewrow = new Button("How to Add New Row");
            static       Button addnewcatrow = new Button("How to Add New  Category Row");

       static      Button howitwork = new Button("How it Works");
          static               Button nextNewVersionContent = new Button("Next New version Content");
        static     Button projectSupervisor = new Button("Search for Project Supervisor");

            static             Button searchRegNo = new Button("Search for REG NUMBER");

                        
                static                                 Button searchfordepartment = new Button("Search for Department");
                static         Button releaseVersion = new Button("Software release by Developer ");
                 static        Button UpdateExpectation = new Button("Update Expectation ");
//         static        Button UpdateExpectation = new Button("Update Expectation ");

                        
                static Stage sdcate;
                static    VBox  lst = new VBox();
webContentsDisplay webload = new webContentsDisplay();
       public   ArticleForTheProgram(){
                 
//                 to stablegui executor using empty constructor
                 }
    public ArticleForTheProgram(Button btn){
        
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
       
                    
                    if(event.getSource()==howtoupadet){
     webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/HOW TO UPDATE.jpg").toExternalForm());

                    
                    }
                    if(event.getSource()==howtoupadetcat){
     webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/How to Update Cat.jpg").toExternalForm());

                    
                    }
                    
                      if(event.getSource()==howtodelet){
     webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/HOW TO Delete.jpg").toExternalForm());

                    
                    }
                if(event.getSource()==howtodeletcat){
     webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/How to Delete Cat.jpg").toExternalForm());

                    
                    }
                
      
                    if(event.getSource()==addnewrow){
    webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/How To Add New Row.jpg").toExternalForm());

                    }

                    if(event.getSource()==addnewcatrow){
    webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/How to add new Cat.jpg").toExternalForm());

                    }
                if(event.getSource()==howitwork){
        webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/How it works/Page1.jpg").toExternalForm());

                    }
                
                 if(event.getSource()==nextNewVersionContent){
      webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/Next version Content.jpg").toExternalForm());

                    }
                 
                  if(event.getSource()==projectSupervisor){
                          webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/Search For Project Supervisor.jpg").toExternalForm());

                    }
                  
                   if(event.getSource()==searchRegNo){
              webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/Search for REG NUMBER.jpg").toExternalForm());

                    }

                   if(event.getSource()==searchfordepartment){
          webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/Search for department.jpg").toExternalForm());

                    }
                
                
                
                if(event.getSource()==UpdateExpectation){
      webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/Update Expectation.jpg").toExternalForm());
    
                    }
                
                
                
                 if(event.getSource()==releaseVersion){
      webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/Software release by Developer.jpg").toExternalForm());
    
                    }
                
                }
            });
        
    }
    
    public  void ArticleForTheProgramButtonBulder(){
    lst.setAlignment(Pos.CENTER);
    lst.setSpacing(10);
                             lst.getStylesheets().add(this.getClass().getResource("/css/articleSTageMaker.css").toExternalForm());
           
lst.getChildren().addAll(howitwork,howtoupadet,howtoupadetcat,howtodelet,howtodeletcat,addnewrow,addnewcatrow,projectSupervisor,searchRegNo,searchfordepartment,nextNewVersionContent,UpdateExpectation,releaseVersion);

                                                new  ArticleForTheProgram(howitwork);
                                               new ArticleForTheProgram(howtoupadet);
                                          new ArticleForTheProgram(howtoupadetcat);

                                                 new ArticleForTheProgram(howtodelet);
                                                 new ArticleForTheProgram(howtodeletcat);

                                               new ArticleForTheProgram(addnewrow);                                      
                                               new ArticleForTheProgram(addnewcatrow);

                                           new ArticleForTheProgram(projectSupervisor);
                                               new ArticleForTheProgram(searchRegNo);
                                              
                                               new ArticleForTheProgram(searchfordepartment);

                                              new ArticleForTheProgram(nextNewVersionContent);
                                               new ArticleForTheProgram(UpdateExpectation);
                                               new ArticleForTheProgram(releaseVersion);
//                                               new ArticleForTheProgram(addnewrow);
//                                               new ArticleForTheProgram(addnewrow);
//                                               new ArticleForTheProgram(addnewrow);

                        
                        
                        
// use catestage  to view it
//CategoryModeling jik = new CategoryModeling();
btmn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
       
//        jik.showCatestageMaker(lst);
        showMyarticlestageMaker();

        
        }
    });
  
    }
    
    
    public void aboutTheApp(Button bt){
    bt.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
      webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/About App1.jpg").toExternalForm());


        
        }
    });
    
    }
    
    
    public void moreaboutTheDev(Button bt){
        bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                                                 webload.showMyarticlestageMaker(this.getClass().getResource("/MyIMGArticle/About developer.jpg").toExternalForm());

            }
        });
    }    
    
  
    
    
     public static void myarticleTageMaker(Stage cat){
        sdcate=cat;

    sdcate.initModality(Modality.WINDOW_MODAL);
    sdcate.initOwner(pri);
        sdcate.setScene(new Scene(lst));

    }
    public static void showMyarticlestageMaker(){

    sdcate.setResizable(false);
    sdcate.show();
    }
}
