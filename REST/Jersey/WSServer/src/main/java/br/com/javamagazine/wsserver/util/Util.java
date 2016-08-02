package br.com.javamagazine.wsserver.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.javamagazine.wsserver.bean.Message;
import br.com.javamagazine.wsserver.bean.User;

public class Util {

	private static List<Message> messages = new ArrayList<Message>();
	private static List<User> users = new ArrayList<User>();

	public static void add(Message msg) {
		Util.messages.add(msg);
	}

	public static void add(User user) {
		Util.users.add(user);
	}

	public static User getUser(User user) {
		for (User u : Util.users) {
			if (u.getName().equalsIgnoreCase(user.getName())) {
				return u;
			}
		}

		return null;
	}

	public static List<User> getUsers() {
		return Util.users;
	}

	public static List<Message> getMessages() {
		return Util.messages;
	}

	public static Message getMessage(int index) {
		return Util.messages.get(index);
	}

	public static void remove(String user) {
		Iterator<User> it = Util.users.iterator();
		while (it.hasNext()) {
			User u = it.next();
			if (user.equalsIgnoreCase(u.getName())) {
				Util.users.remove(u);
				break;
			}
		}
	}

	public static void removeAll() {
		Util.users.clear();
		Util.messages.clear();
	}

}
