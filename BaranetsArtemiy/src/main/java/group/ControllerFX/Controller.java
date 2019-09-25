package group.ControllerFX;

import group.dao.*;
import group.dao.impl.*;
import group.entily.*;
import group.insert.CourseBild;
import group.insert.GroupBild;
import group.service.*;
import group.service.impl.*;
import hibernate.Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Controller {
    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableView<Group> courseTable;
    @FXML
    private TableView<Student> tableViewStudent;
    @FXML
    private TableView<RatingFirstCourse> tableViewFirst;
    @FXML
    private TableView<RatingSecondCourse> tableViewSecond;


    @FXML private TableColumn<Course,Integer> coure_id;
    @FXML private TableColumn<Course,String> decsription;
    @FXML private TableColumn<Course,String> titleCourse;
    @FXML private TableColumn<Group,Integer> groupId;
    @FXML private TableColumn<Group, Time> begin;
    @FXML private TableColumn<Group, Time> end;
    @FXML private TableColumn<Group,Integer> coureIdGrop;
    @FXML private TableColumn<Group,String> titleGroup;

    @FXML private TableColumn<Student, String> fullName;
    @FXML private TableColumn<Student,Integer> student_id;
    @FXML private TableColumn<Student,Integer> group_id;

    @FXML private TableColumn<RatingFirstCourse, String> mathFirst;
    @FXML private TableColumn<RatingFirstCourse,String> progFirst;
    @FXML private TableColumn<RatingFirstCourse,String> idFirst;


    @FXML private TableColumn<RatingSecondCourse, String> mathSecond;
    @FXML private TableColumn<RatingSecondCourse,String> progSecond;
    @FXML private TableColumn<RatingSecondCourse,String> idSecond;

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void error(String str){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(str);

        alert.showAndWait();
    }



    @FXML
    private void NewLineStudent(){







    }
    @FXML
    private void UpdateStudent(){
        tableViewStudent.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells1 = tableViewStudent.getSelectionModel().getSelectedCells();
        StudentServise studentServise = new StudentServiseImpl();
        StudentDao studentDao = new StudentDAOImpl();

        ObservableList<Student> usersData = FXCollections.observableArrayList();

        fullName.setCellValueFactory(new PropertyValueFactory<Student, String>("fullName"));
        student_id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("idRating"));
        group_id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("groupId"));

        Locale.setDefault(Locale.ENGLISH);

        CourseDao courseDao = new CourseDAOImpl();

        HibernateUtil.getFactory().close();

        System.out.println("/////////////////////////////////////////////////////");
        List<Student> list = studentDao.findAll();

//        try {
//            System.out.println(list);
//            for (Student a : list) {
//                System.out.println(a.getId() + "    "  + a.getDescription()+ "    " + a.getTitle());
//
//            }}catch (Exception e){
//            e.printStackTrace();
//        }
//
        ObservableList<Student> observableArrayList = FXCollections.observableArrayList(list);
        try {
            usersData.addAll(observableArrayList);
            for (Student p : list) {

                usersData.add(p);

                System.out.println("usersData\n" + usersData);
                System.out.println("Получена запись: " + p);
            }
            tableViewStudent.setItems(usersData);


        }
        catch (Exception e){
            System.out.println("Обновлений в таблице нет");
        }

    }
    @FXML
    private void DeleteStudent(){
    }
    @FXML
    private void EditStudent(){

    }
    @FXML
    private void NewLineFirst(){

    }
    @FXML
    private void UpdateFirst(){
        tableViewFirst.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells1 = tableViewFirst.getSelectionModel().getSelectedCells();
        StudentServise studentServise = new StudentServiseImpl();
        StudentDao studentDao = new StudentDAOImpl();

        ObservableList<RatingFirstCourse> usersData = FXCollections.observableArrayList();

        mathFirst.setCellValueFactory(new PropertyValueFactory<RatingFirstCourse, String>("ratingProg"));
        progFirst.setCellValueFactory(new PropertyValueFactory<RatingFirstCourse, String>("ratingMach"));
        idFirst.setCellValueFactory(new PropertyValueFactory<RatingFirstCourse, String>("midRating"));

        Locale.setDefault(Locale.ENGLISH);

        CourseDao courseDao = new CourseDAOImpl();

        HibernateUtil.getFactory().close();

        System.out.println("/////////////////////////////////////////////////////");

        RatingFirstCourseService ratingFirstCourseService = new RatingFirstCourseServiceImpl();
        RatingFirstCourseDao ratingFirstCourse= new RatingFirstCourseDAOImpl();
        List<RatingFirstCourse> list = ratingFirstCourse.findAll();

        ObservableList<RatingFirstCourse> observableArrayList = FXCollections.observableArrayList(list);
        try {
            usersData.addAll(observableArrayList);
            for (RatingFirstCourse p : list) {

                usersData.add(p);

                System.out.println("usersData\n" + usersData);
                System.out.println("Получена запись: " + p);
            }
            tableViewFirst.setItems(usersData);


        }
        catch (Exception e){
            System.out.println("Обновлений в таблице нет");
        }

    }
    @FXML
    private void DeleteFirst(){
    }
    @FXML
    private void EditFirst(){

    }
    @FXML
    private void NewLineSecond(){

    }
    @FXML
    private void UpdateSecond(){
        tableViewSecond.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells1 = tableViewSecond.getSelectionModel().getSelectedCells();
        StudentServise studentServise = new StudentServiseImpl();
        StudentDao studentDao = new StudentDAOImpl();

        ObservableList<RatingSecondCourse> usersData = FXCollections.observableArrayList();

        mathSecond.setCellValueFactory(new PropertyValueFactory<RatingSecondCourse, String>("ratingProg"));
        progSecond.setCellValueFactory(new PropertyValueFactory<RatingSecondCourse, String>("ratingMach"));
        idSecond.setCellValueFactory(new PropertyValueFactory<RatingSecondCourse, String>("test"));

        Locale.setDefault(Locale.ENGLISH);

        CourseDao courseDao = new CourseDAOImpl();

        HibernateUtil.getFactory().close();

        System.out.println("/////////////////////////////////////////////////////");

        RatingSecondCourseService ratingFirstSecondService = new RatingSecondCourseServiceImpl();
        RatingSecondCourseDao ratingSecondCourse= new RatingSecondCourseDAOImpl();

        List<RatingSecondCourse> list = ratingSecondCourse.findAll();

        ObservableList<RatingSecondCourse> observableArrayList = FXCollections.observableArrayList(list);
        try {
            usersData.addAll(observableArrayList);
            for (RatingSecondCourse p : list) {

                usersData.add(p);

                System.out.println("usersData\n" + usersData);
                System.out.println("Получена запись: " + p);
            }
            tableViewSecond.setItems(usersData);


        }
        catch (Exception e){
            System.out.println("Обновлений в таблице нет");
        }
    }
    @FXML
    private void DeleteSecond(){
    }
    @FXML
    private void EditSecond(){

    }



    @FXML
    public void initialize(){
        ObservableList<Group> usersData = FXCollections.observableArrayList();

        groupId.setCellValueFactory(new PropertyValueFactory<Group, Integer>("id"));
        begin.setCellValueFactory(new PropertyValueFactory<Group, Time>("begin"));
        end.setCellValueFactory(new PropertyValueFactory<Group, Time>("end"));
        coureIdGrop.setCellValueFactory(new PropertyValueFactory<Group, Integer>("courseId"));
        titleGroup.setCellValueFactory(new PropertyValueFactory<Group, String>("title"));

        Locale.setDefault(Locale.ENGLISH);

        CourseService courseService = new CourseServiceImpl();
        CourseDao courseDao = new CourseDAOImpl();

        HibernateUtil.getFactory().close();

        GroupService groupService = new GroupServiceImpl();
        GroupDao groupDao = new GroupDAOImpl();

        StudentServise studentServise = new StudentServiseImpl();
        StudentDao studentDao = new StudentDAOImpl();

        RatingSecondCourseService ratingSecondCourseService = new RatingSecondCourseServiceImpl();
        RatingSecondCourseDao ratingSecondCourse= new RatingSecondCourseDAOImpl();

        RatingFirstCourseService ratingFirstCourseService = new RatingFirstCourseServiceImpl();
        RatingFirstCourseDao ratingFirstCourse= new RatingFirstCourseDAOImpl();


        Course course1 = courseService
                .create("Course 1", "Description 1");
        Course course2 = courseService
                .create("Course 2", "Description 2");
        Course course3 = courseService
                .create("Course 3", "Description 3");


        Group group1 = groupService
                .create(course1, "Group 1 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Group group2 = groupService
                .create(course1, "Group 2 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Group group3 = groupService
                .create(course1, "Group 2 - CRS 1",
                        Calendar.getInstance().getTime(),
                        Calendar.getInstance().getTime());

        Student student1 = studentServise.create(group1,"Artemiy3");
        Student student2 = studentServise.create(group1,"Vlad1");
        Student student3 = studentServise.create(group1,"Dolik3");

        ratingSecondCourseService.create(student1,"75","75");
        ratingSecondCourseService.create(student2,"80","80");
        ratingSecondCourseService.create(student3,"67","78");

        ratingFirstCourseService.create(student1,"75","75");
        ratingFirstCourseService.create(student2,"80","80");
        ratingFirstCourseService.create(student3,"67","78");

        group1.getStudents().add(student1);
        group2.getStudents().add(student2);
        group3.getStudents().add(student3);


        course1.getGroups().add(group1);
        course2.getGroups().add(group2);
        course3.getGroups().add(group3);

        courseService.update(course1);
        courseService.update(course2);
        courseService.update(course3);


        ObservableList selectedCells1 = tableView.getSelectionModel().getSelectedCells();
        ObservableList selectedCells2 = courseTable.getSelectionModel().getSelectedCells();
        ObservableList selectedCells3 = tableViewStudent.getSelectionModel().getSelectedCells();
        ObservableList selectedCells4 = tableViewFirst.getSelectionModel().getSelectedCells();
        ObservableList selectedCells5 = tableViewSecond.getSelectionModel().getSelectedCells();


        selectedCells2.addListener(new ListChangeListener() {//пол выделеного элемента
            @Override
            public void onChanged(Change c) {
                try {
                    System.out.println();
                    TablePosition tablePosition = (TablePosition) selectedCells1.get(0);
                    Object val = null;
                    val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println("Selected Value " + val);
                } catch (Exception e) {
                    System.out.println("Ну бывает..");
                }

            }
        });
        selectedCells2.addListener(new ListChangeListener() {//пол выделеного элемента
            @Override
            public void onChanged(Change c) {
                try {
                    System.out.println();
                    TablePosition tablePosition = (TablePosition) selectedCells1.get(0);
                    Object val = null;
                    val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println("Selected Value " + val);
                } catch (Exception e) {
                    System.out.println("Ну бывает..");
                }

            }
        });
        selectedCells3.addListener(new ListChangeListener() {//пол выделеного элемента
            @Override
            public void onChanged(Change c) {
                try {
                    System.out.println();
                    TablePosition tablePosition = (TablePosition) selectedCells1.get(0);
                    Object val = null;
                    val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println("Selected Value " + val);
                } catch (Exception e) {
                    System.out.println("Ну бывает..");
                }

            }
        });

        selectedCells4.addListener(new ListChangeListener() {//пол выделеного элемента
            @Override
            public void onChanged(Change c) {
                try {
                    System.out.println();
                    TablePosition tablePosition = (TablePosition) selectedCells1.get(0);
                    Object val = null;
                    val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println("Selected Value " + val);
                } catch (Exception e) {
                    System.out.println("Ну бывает..");
                }

            }
        });
        selectedCells5.addListener(new ListChangeListener() {//пол выделеного элемента
            @Override
            public void onChanged(Change c) {
                try {
                    System.out.println();
                    TablePosition tablePosition = (TablePosition) selectedCells1.get(0);
                    Object val = null;
                    val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println("Selected Value " + val);
                } catch (Exception e) {
                    System.out.println("Ну бывает..");
                }

            }
        });
    }


    @FXML
    private void NewLineCourse(){

        CourseService courseService = new CourseServiceImpl();
        CourseDao courseDao = new CourseDAOImpl();



        Locale.setDefault(Locale.ENGLISH);
        Stage newWindow = new Stage();
        Button button = new Button("Cоздать");
        javafx.scene.control.TextField NAME = new javafx.scene.control.TextField();
        NAME.setText("NAME COURSE");
        javafx.scene.control.TextField SURENAME = new javafx.scene.control.TextField();
        SURENAME.setText("TITLE");

        Label secondLabel = new Label("Создать новую запись?");
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);




        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String name = NAME.getText();
                String surename = SURENAME.getText();

                if(isNumeric(name) == true||isNumeric(surename) == true){
                    error("Name/surename field cannot contain numbers\n");
                }else {
                    Course course1 = courseService
                            .create(name, surename);

                }
                newWindow.close();
            }
        });



        root.getChildren().addAll(secondLabel,NAME,SURENAME, button);
        Scene secondScene = new Scene(root, 230, 300);
        newWindow.setScene(secondScene);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
        UpdateCourse();





    }
    @FXML
    private void UpdateCourse(){



        tableView.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells1 = tableView.getSelectionModel().getSelectedCells();


        ObservableList<Course> usersData = FXCollections.observableArrayList();

        coure_id.setCellValueFactory(new PropertyValueFactory<Course, Integer>("id"));
        decsription.setCellValueFactory(new PropertyValueFactory<Course, String>("title"));
        titleCourse.setCellValueFactory(new PropertyValueFactory<Course, String>("description"));

        Locale.setDefault(Locale.ENGLISH);

        CourseDao courseDao = new CourseDAOImpl();

        HibernateUtil.getFactory().close();

        System.out.println("/////////////////////////////////////////////////////");
        List<Course> list = courseDao.findAll();

        try {
            System.out.println(list);
            for (Course a : list) {
                System.out.println(a.getId() + "    "  + a.getDescription()+ "    " + a.getTitle());

            }}catch (Exception e){
            e.printStackTrace();
        }
//
        ObservableList<Course> observableArrayList = FXCollections.observableArrayList(list);
        try {
            usersData.addAll(observableArrayList);
            for (Course p : list) {

                usersData.add(p);

                System.out.println("usersData\n" + usersData);
                System.out.println("Получена запись: " + p);
            }
            tableView.setItems(usersData);


        }
        catch (Exception e){
            System.out.println("Обновлений в таблице нет");
        }


    }






    @FXML
    private void DeleteCourse(){

    }
    @FXML
    private void EditCourse(){

    }
    @FXML
    private void NewLineGroup(){

    }
    @FXML
    private void UpdateGroup(){
        courseTable.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells1 = courseTable.getSelectionModel().getSelectedCells();


        ObservableList<Group> usersData = FXCollections.observableArrayList();

        groupId.setCellValueFactory(new PropertyValueFactory<Group, Integer>("id"));
        begin.setCellValueFactory(new PropertyValueFactory<Group, Time>("begin"));
        end.setCellValueFactory(new PropertyValueFactory<Group, Time>("end"));
        coureIdGrop.setCellValueFactory(new PropertyValueFactory<Group, Integer>("courseId"));
        titleGroup.setCellValueFactory(new PropertyValueFactory<Group, String>("title"));

        Locale.setDefault(Locale.ENGLISH);


        HibernateUtil.getFactory().close();

        GroupDao groupDao = new GroupDAOImpl();


        System.out.println("/////////////////////////////////////////////////////");
        List<Group> list = groupDao.findAll();

//        try {
//            System.out.println(list);
////            for (Group a : list) {
////                System.out.println(a.getId() + "    "  + a.getDescription()+ "    " + a.getTitle());
////
////            }}catch (Exception e){
////            e.printStackTrace();
//        }
//
        ObservableList<Group> observableArrayList = FXCollections.observableArrayList(list);
        try {
            usersData.addAll(observableArrayList);
            for (Group p : list) {

                usersData.add(p);

                System.out.println("usersData\n" + usersData);
                System.out.println("Получена запись: " + p);
            }
            courseTable.setItems(usersData);


        }
        catch (Exception e){
            System.out.println("Обновлений в таблице нет");
        }


    }
    @FXML
    private void DeleteGroup(){

    }
    @FXML
    private void EditGroup(){

    }




}
