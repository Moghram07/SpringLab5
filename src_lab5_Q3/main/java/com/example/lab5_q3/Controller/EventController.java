package com.example.lab5_q3.Controller;

import com.example.lab5_q3.ApiResponse.ApiResponse;
import com.example.lab5_q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();
    @GetMapping("/get")
    public java.util.ArrayList<Event> getEvents() { return events; }
    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added", "200");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("Event updated", "200");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Event deleted", "200");
    }
    @PutMapping("/change/{index}/{capacity}")
    public ApiResponse changeEventCapacity(@PathVariable int index, @PathVariable int capacity) {
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Event capacity changed", "200");
    }
    @GetMapping("/search/{name}")
    public ApiResponse searchEvents(@PathVariable String name) {
        for (Event event : events) {
            if(event.getId().equals(name)){
                return new ApiResponse("Event found" + event.toString(), "200");
            }
        }
        return new ApiResponse("Event not found", "404");
    }

}
