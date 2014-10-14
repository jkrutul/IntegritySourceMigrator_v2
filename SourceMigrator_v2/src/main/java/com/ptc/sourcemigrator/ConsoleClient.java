package com.ptc.sourcemigrator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ptc.sourcemigrator.models.Member;
import com.ptc.sourcemigrator.models.Project;
import com.ptc.sourcemigrator.models.Sandbox;
import com.ptc.sourcemigrator.utils.APIUtils;

public class ConsoleClient {
	private SourceMigrator sm = new SourceMigrator();
	String menu = "\n----DATABASE----\n" + "1. List all projects \n"
			+ "2. List Members from project\n"
			+ "3. Export project to database\n" + "----SERVER "
			+ sm.src.getHostname() + "---\n" + "4. List all projects\n"
			+ "5. List Members from project\n" + "6. Get project revisions\n"
			+ "----SERVER " + sm.dest.getHostname() + "---\n"
			+ "7. List all projects\n" + "8. List Members from project\n"
			+ "9. Get project revisions\n" + "----APPLICATION----\n"
			+ "10. Migrate project to destination server\n"
			+ "11. Display servers info\n" + "12. Display sandboxes\n"
			+ "13. Drop sandbox\n"
			// + "14. Drop all sandbox\n"
			+ "15. Close application.\n" + "Your choice:";

	public ConsoleClient() {
		while (true) {
			int selection;
			try {
				selection = Integer.parseInt(readFromCmd(menu));
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
				continue;
			}
			switch (selection) {

			case 1:
				for (Project p : sm.db
						.selectProject(readFromCmd("Enter project name:"))) {
					System.out.println(p);
				}
				break;

			case 2:
				List<Project> projects = sm.db
						.selectProject(readFromCmd("Enter project name:"));
				Project project = null;
				if (!projects.isEmpty()) {
					project = projects.get(0);
				}
				for (Member m : sm.db.selectMembers(project)) {
					System.out.println(m);
				}
				break;

			case 3:
				sm.exportProjectFromServerToDatabase(readFromCmd("Enter project name:"));
				break;

			case 4:
				for (Project p : sm.src.getProjects(true,
						readFromCmd("Enter project name:"),
						readFromCmd("Enter project revision:"))) {
					System.out.println(p);
				}
				break;

			case 5: { // LIST MEMBERS FROM PROJECT
				int i = 0;
				List<Project> prs = sm.src.getProjects(true, null, null);
				for (Project p : prs) {
					System.out.println("ID:" + i++ + " " + p.getName() + "\t"
							+ p.getIsShared() + "\t" + p.getParent());
				}
				int projectId = Integer
						.parseInt(readFromCmd("Select project:"));
				Project pr = prs.get(projectId);
				System.out.println(sm.src.getProjectRevisions(pr.getName()));

				String projectRevision = readFromCmd("Enter project revision:");

				for (Member m : sm.src.getMembers(pr.getName(),
						projectRevision, sm.src.getHostname())) {
					System.out.println(m);
				}
				break;
			}

			case 6:
				System.out
						.println(sm.src
								.getProjectRevisions(readFromCmd("Enter project name:")));
				break;

			case 7:
				for (Project p : sm.dest.getProjects(true,
						readFromCmd("Enter project name:"),
						readFromCmd("Enter project revision:"))) {
					System.out.println(p);
				}
				break;

			case 8:
				for (Member m : sm.dest.getMembers(
						readFromCmd("Enter project name:"),
						readFromCmd("Enter project revision:"),
						sm.src.getHostname())) {
					System.out.println(m);
				}
				break;

			case 9:
				System.out
						.println(sm.dest
								.getProjectRevisions(readFromCmd("Enter project name:")));
				break;

			case 10: {// Migrate project

				int i = 0;
				List<Project> prs = sm.src.getProjects(true, null, null);
				for (Project p : prs) {
					System.out.println("ID:" + i++ + " " + p.getName() + "\t"
							+ p.getIsShared() + "\t" + p.getParent());
				}
				int projectId = Integer
						.parseInt(readFromCmd("Select project:"));
				Project pr = prs.get(projectId);
				System.out.println(sm.src.getProjectRevisions(pr.getName()));

				String projectRevision = readFromCmd("Enter project revision:");
				String rootDir = readFromCmd("Enter path to directory for migrated project:");
				sm.migrateProject(pr.getName(), projectRevision, rootDir);
				break;
			}

			case 11:
				System.out.println("SOURCE SERVER: [" + sm.src + "]");
				System.out.println("DESTINATION SERVER: [" + sm.dest + "]");
				break;

			case 12: {
				System.out.println("SANDBOXES");
				List<Sandbox> sandboxes = sm.src.getSandboxes(null, null);
				for (Sandbox s : sandboxes) {
					System.out.println(s);
				}
				break;
			}

			case 13: {
				System.out.println("SANDBOXES");
				List<Sandbox> sandboxes = sm.src.getSandboxes(null, null);
				int i = 0;
				for (Sandbox s : sandboxes) {
					System.out.println("ID: " + i++ + " " + s);
				}
				int sandboxId = Integer
						.parseInt(readFromCmd("Select sandbox to delete:"));
				Sandbox sandbox = sandboxes.get(sandboxId);
				sm.dest.dropSandbox(sandbox.getName(),
						APIUtils.DELETION_POLICY_ALL);
				break;
			}
			/*
			 * case 14: //close application
			 * sm.dest.dropAllSandboxes(APIUtils.DELETION_POLICY_ALL); break;
			 */
			case 15: // close application
				sm.endEndSessionAndCloseDb();
				return;

			default:
				System.out.println("Option: " + selection
						+ " doesn't exist, please try again");
				break;
			}
		}
	}

	private String readFromCmd(String message) {
		System.out.print(message);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String output = br.readLine();
			if (output.isEmpty()) {
				return null;
			} else {
				return output;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
