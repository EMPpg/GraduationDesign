package Dao;

public class postData {
	public postData() {
		this.postID = 0;
		this.postName = "";
		this.postContent = "";
		this.postTime = "";
		this.likeNumber = 0;
		this.account = 0;
	}
	public postData(int postID, String postName, String postContent, String postTime, int likeNumber, int account) {
		super();
		this.postID = postID;
		this.postName = postName;
		this.postContent = postContent;
		this.postTime = postTime;
		this.likeNumber = likeNumber;
		this.account = account;
	}
	public int postID;
	public String postName;
	public String postContent;
	public String postTime;
	public int likeNumber;
	public int account;
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public int getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
}
