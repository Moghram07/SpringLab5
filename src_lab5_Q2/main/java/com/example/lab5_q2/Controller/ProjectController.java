package com.example.lab5_q2.Controller;

import com.example.lab5_q2.ApiResponse.ApiResponse;
import com.example.lab5_q2.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/get")
    public java.util.ArrayList<Project> getProjects() { return projects; }
    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("project added", "200");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResponse("project updated", "200");
    }
    @DeleteMapping("/delete")
    public ApiResponse deleteProject(int index) {
        projects.remove(index);
        return new ApiResponse("project deleted", "200");
    }
    @PutMapping("/change/{index}")
    public ApiResponse changeProjectStatus(@PathVariable int index) {
        if(projects.get(index).getStatus().equals("done")) {
            projects.get(index).setStatus("not done");
        }else{
            projects.get(index).setStatus("done");
        }
        return new ApiResponse("project status changed", "200");
    }
    @GetMapping("/getAll/{name}")
    public ApiResponse getAllCompanyProjects(@PathVariable String name){
        for(Project project1 : projects){
            if(project1.getCompanyName().equals(name)){
                return new ApiResponse("projects by company name found" + project1.toString(), "200");
            }
        }
        return new ApiResponse("projects by company name not found", "404");
    }
}
