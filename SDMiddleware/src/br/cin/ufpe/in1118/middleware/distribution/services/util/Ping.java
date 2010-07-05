package br.cin.ufpe.in1118.middleware.distribution.services.util;

import java.io.InputStream;
import java.util.Scanner;

public class Ping {

	private static Runtime runtime = Runtime.getRuntime();

	private static String REPLY = "Reply";
	private static String TIME = "time";
	private static String MS = "ms";
	
	static {
		try {
			Process proc = runtime.exec("cmd /C echo");
			proc.waitFor();
			InputStream inputStream = proc.getInputStream();
			
			byte[] array = new byte [inputStream.available()];
			inputStream.read(array);
			
			boolean english = (new String(array, "US-ASCII").trim().equals("ECHO is on."));
			
			if (!english) {
				REPLY = "Resposta";
				TIME = "tempo";
			}
			
		} catch (Exception e) {
			//TODO O que deverá ser feito!?
		}
	}

	public static int ping(String endereco){
		try {
			Process process = runtime.exec("ping -n 1 -4 " + endereco);

			Scanner scanner = new Scanner(process.getInputStream());

			String replyLine = TIME + "=-1";

			while (scanner.hasNextLine()) {
				String tmp = scanner.nextLine().trim();

				if (tmp.startsWith(REPLY) && tmp.contains(TIME)) {
					replyLine = tmp;
				}
			}

			int posicaoTime = replyLine.indexOf(TIME) + TIME.length() + 1;

			String linhaPodada = replyLine.substring(posicaoTime);
			int posicaoMS = linhaPodada.indexOf(MS);

			return Integer.parseInt(linhaPodada.substring(0, posicaoMS));
		} catch (Exception e) {
			return -1;
		}
	}

}
