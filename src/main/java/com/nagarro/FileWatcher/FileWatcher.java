package com.nagarro.FileWatcher;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.service.FindService;

public class FileWatcher implements Runnable {
	
	@Autowired
	FindService findservice;
	public void filewatcher() {
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Path path=Paths.get("Files");
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
			WatchKey key;
			while((key=watchService.take())!=null) {
				for(WatchEvent<?> event: key.pollEvents()) {
					System.out.println(event.context());
					findservice.truncateData();
					findservice.readData();
				}
			}
			key.reset();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		filewatcher();
	}
}
