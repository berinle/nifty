package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import views.html.post.*;
import models.*;

public class Application extends Controller {
  
  final static Form<Post> postForm = form(Post.class);

  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public static Result posts(){

  	return ok(list.render(Post.find.all()));
  }

  public static Result blankPostForm(){
  	return ok(add.render(postForm));
  }

  public static Result addPost(){
  	Form<Post> filledForm = postForm.bindFromRequest();
  	if(filledForm.hasErrors()){
  		return badRequest(add.render(filledForm));
  	}

  	filledForm.get().save();

  	for(Post p: Post.find.all()){
  		System.out.println(p);
  	}

  	// return ok(list.render(Post.find.all()));
  	return redirect(routes.Application.posts());
  }
  
}