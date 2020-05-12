package com.latencot.platoon.retrofit;

public class ApiHelper {
    public static final String BaseURL = "http://192.168.0.102/garbageboat/api/v1/";
    public static final String login = "authentication/login.php";
    public static final String login_without_password = "authentication/login_without_password.php";
    public static final String login_with_email_and_mobile_no = "authentication/upload_credentials_with_login.php";
    public static final String upload_credentials = "authentication/upload_credentials_if_not_exist.php";
    public static final String get_user_data = "profile/users_get_data.php";
    public static final String get_user_all_data = "profile/users_get_all_data.php";
    public static final String update_user_data = "authentication/users_update_primary.php";
    public static final String register_user = "authentication/users_register.php";
    public static final String update_location = "authentication/users_update_location.php";
    public static final String upload_image = "authentication/upload_logo_image.php";
    public static final String upload_feedback = "userpanel/feedback.php";
    public static final String upload_problem = "userpanel/problem_upload.php";
    public static final String upload_solution = "userpanel/solution_upload.php";
    public static final String get_specific_problems = "userpanel/problem_get_specific.php";
    public static final String get_specific_solutions = "userpanel/solution_get_specific.php";
    public static final String get_all_problems = "userpanel/problem_get_all.php";
    public static final String get_all_solutions = "userpanel/solution_get_all.php";
    public static final String add_boat = "boats/boats_update.php";
    public static final String get_boats_all = "boats/boats_get_all.php";
    public static final String get_boat_specific = "boats/boats_get_specific.php";
    public static final String delete_boat_specific = "boats/boats_delete.php";
    public static final String get_all_projects = "projects/projects_get_all.php";
    public static final String get_specific_projects = "projects/projects_get_specific.php";
    public static final String add_project = "projects/projects_insert.php";
    public static final String delete_project = "projects/projects_delete.php";
    public static final String update_project_location = "projects/projects_update_location.php";
    public static final String get_associated_boats = "boats/boats_get_associated.php";
    public static final String get_boats_unmapped = "boats/boats_get_unmapped.php";
    public static final String add_boat_to_project = "projects/add_boat_to_project.php";
    public static final String delete_boat_from_project = "projects/delete_boat_from_project.php";
    public static final String get_project_specific_boats = "projects/project_get_boats.php";
}
