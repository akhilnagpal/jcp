package java9;

import static java.util.Comparator.comparing;

import java.time.Instant;

// To show ProcessHanlde, ProcessHandleInfo classes
public class ProcessHandleClient {

	public static void main(String[] args) throws Exception {
		ProcessHandle.allProcesses().map(ProcessHandle::info).sorted(comparing(info->info.startInstant().orElse(Instant.MAX))).forEach(ProcessHandleClient::printProcessHandleInfo);
		ProcessHandle handle = ProcessHandle.allProcesses().filter(processHandle-> processHandle.info().command().map(cmd-> cmd.contains("BT")).orElse(false)).
			findFirst().orElseThrow(()-> new IllegalAccessException("Process does not exist"));
		System.out.println(handle.info());
		//Writing future expression once the process is destroyed
		handle.onExit().thenAccept(processHandle-> System.out.print(handle.info().command().get() + " is now killed"));
		
		boolean shutdown = handle.destroy();
		// forcing main thread to wait until completable future thread is finished
		handle.onExit().join();
		System.out.println("Shutdown " + shutdown);
		

		
	}
	
	private static void printProcessHandleInfo(ProcessHandle.Info info) {
		if(info.startInstant().isPresent() && info.command().isPresent()) {
			System.out.printf("started at : %s command : %s \n",info.startInstant().get(),info.command().get());
		}
	}

}
