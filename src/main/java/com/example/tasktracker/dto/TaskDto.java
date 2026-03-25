package com.example.tasktracker.dto;

public class TaskDto {
	 private Long id;
	    private String title;
	    private String description;
	    private String status;
	    private String userName;
	    private String projectName;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		@Override
		public String toString() {
			return "TaskDto [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
					+ ", userName=" + userName + ", projectName=" + projectName + "]";
		}

	    
}
