package buchungssystem.models.application;

import buchungssystem.models.Model;

public class UserRoleHasPermission extends Model  {
	private int userRoleID;
	private int permissionsID;
	
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	public int getPermissionsID() {
		return permissionsID;
	}
	public void setPermissionsID(int permissionsID) {
		this.permissionsID = permissionsID;
	}
	
	@Override
	public String toString() {
		return "UserRoleHasPermission [userRoleID=" + userRoleID + ", permissionsID=" + permissionsID + "]";
	}
	
}
