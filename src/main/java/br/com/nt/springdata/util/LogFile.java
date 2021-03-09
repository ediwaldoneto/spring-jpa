package br.com.nt.springdata.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class LogFile {

	private LogFile() {
	}

	private static final String ESPACO_EM_BRANCO = " ";
	private static final String PATH_LOG = "C:\\log\\";
	private static final String FILE_NAME = "activity.log";

	public static void writeLog(String info) {

		String dataHora = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		File file = new File(PATH_LOG);
 
		if (!file.exists()) {
			file.mkdir();
		}

		String path = PATH_LOG + FILE_NAME;
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			
			fw = new FileWriter(path, true);
			bw = new BufferedWriter(fw);

			bw.write("INFO " + "[" + dataHora + "]" + ESPACO_EM_BRANCO + info);
			bw.write("\n");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
