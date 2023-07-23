import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	static int choice, reservationStart = 0, reservationEnd = 0;
	static String hotelName;
	static String roomType = null;
	static String reservationMonth;
	static String CitySpecific;
	static String cityName;
	static String searchByHotelName;
	static List <Services> allServices = new ArrayList <Services>();
	static List <Calculable> calculableList = new ArrayList<>();
	static ArrayList <String> roomNames = new ArrayList<String>(
			Arrays.asList("Single", "Double", "Club", "Family", "FamilyView", "Suite"));	
	static boolean loopCheck = true;
	static final String CSV_FILE_PATH = "reservations.csv";
	static boolean loadClicked = false;
	
	
	public static void main(String[] args) throws RoomTypeException{
		/*
		JMenu menuFile = new JMenu ("File");
		JMenuItem itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
				
		JMenu newFile = new JMenu ("New");
		JMenuItem itemReservation = new JMenuItem("Reservation");
		JMenuItem itemServices = new JMenuItem("Services");
		newFile.add(itemReservation);
		newFile.add(itemServices);
		
		JMenu helpFile = new JMenu ("Help");
		JMenuItem itemContents = new JMenuItem ("Contents");
		JMenuItem itemAbout = new JMenuItem ("About");
		helpFile.add(itemContents);
		helpFile.add(itemAbout);
		
		JButton displayReservationsButton = new JButton ("Display Reservations");
		JButton displayExtraServicesButton = new JButton ("Display Extra Services");
		JButton dispResForCity = new JButton ("Disp. Res. For City");
		JButton multiSearchButton = new JButton ("Multithread Search");
		JButton saveReserv = new JButton ("Save Reservations");
		JButton loadReserv = new JButton ("Load Reservations");		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuFile);
		menuBar.add(newFile);
		menuBar.add(helpFile);
		
		JTextArea textArea = new JTextArea (5, 5);
		
		JPanel myPanel1 = new JPanel();
		myPanel1.setPreferredSize(new Dimension(600, 400));
		myPanel1.setLayout(null);
		myPanel1.add(displayReservationsButton);
		myPanel1.add(displayExtraServicesButton);
		myPanel1.add(dispResForCity);
		myPanel1.add(multiSearchButton);
		myPanel1.add(saveReserv);
		myPanel1.add(loadReserv);
		myPanel1.add(menuBar);
		myPanel1.add(textArea);
		
		displayReservationsButton.setBounds(80, 35, 180, 20);
		displayExtraServicesButton.setBounds(270, 35, 180, 20);
		dispResForCity.setBounds(80, 60, 180, 20);
		multiSearchButton.setBounds(270, 60, 180, 20);
		saveReserv.setBounds(60, 430, 180, 20);
		loadReserv.setBounds(295, 430, 180, 20);
		menuBar.setBounds(0, 0, 635, 25);
		textArea.setBounds(15, 90, 505, 330);
		
		JFrame myJf = new JFrame();
		myJf.setTitle("Hotel Reservation System");
		myJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myJf.getContentPane().add(myPanel1);
		myJf.setSize(new Dimension(550, 500));
		myJf.setLocationRelativeTo(null);
		myJf.setVisible(true);
		myJf.setResizable(false);
		
		// File -> Exit
        itemExit.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.exit(0);
            }
        });
        // New->Reservation
        itemReservation.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        				
        		cityName = JOptionPane.showInputDialog("Enter City");
        		hotelName = JOptionPane.showInputDialog("Hotel Name");
        		reservationMonth = JOptionPane.showInputDialog("Reservation Month");
        		boolean loopCheck2 = false;
        		while(!loopCheck2) {
					try {
						reservationStart = Integer.parseInt(JOptionPane.showInputDialog("Reservation Start"));
						loopCheck2 = true;
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error: Reservation Start must be a numeric value!");
					}
				}
        		
        		boolean loopCheck3 = false;
				while(!loopCheck3) {
					try {
						reservationEnd = Integer.parseInt(JOptionPane.showInputDialog("Reservation End"));
						loopCheck3 = true;
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Error: Reservation End must be a numeric value!");
					}
				}
				
				while(reservationEnd - reservationStart > 30) { // not to enter more than 30 days
					JOptionPane.showMessageDialog(null, "Error: The maximum possible reservation period is 30 days.");
					loopCheck2 = false;
	        		while(!loopCheck2) {
						try {
							reservationStart = Integer.parseInt(JOptionPane.showInputDialog("Reservation Start"));
							loopCheck2 = true;
						}
						catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error: Reservation Start must be a numeric value!");
						}
					}
	        		
	        		loopCheck3 = false;
					while(!loopCheck3) {
						try {
							reservationEnd = Integer.parseInt(JOptionPane.showInputDialog("Reservation End"));
							loopCheck3 = true;
						}
						catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error: Reservation End must be a numeric value!");
						}
					}
				}
				
				ReservationSystemMain newReservation = new ReservationSystemMain(cityName, hotelName, reservationMonth
						, reservationStart, reservationEnd);
				newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
				allServices.add(newReservation);	
				calculableList.add(newReservation);
        	}
        });
        
        // New->Services
        itemServices.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		int select1 = 0, ID = 0, piecesOfClothing = 0, days = 0;
				boolean loopCheck4 = false;
				select1 = Integer.parseInt(JOptionPane.showInputDialog("Please select one of the extra services from below:\n"
						+ "1. Laundry Service\n2. Spa Service"));
				if (select1 == 1) {
					Laundry service = new Laundry();
					ID = Integer.parseInt(JOptionPane.showInputDialog("Type the reservation ID to credit this service:"));
					service.setCustomerID(ID);
					loopCheck4 = false;
					while(!loopCheck4) {
						try {
							piecesOfClothing = Integer.parseInt(JOptionPane.showInputDialog("How many pieces of clothing?"));
							loopCheck4 = true;
						}
						catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
						}
					}
					service.setClothingPieces(piecesOfClothing);
					service.calculateService();
					allServices.add(service);
					calculableList.add(service);
				}
				else if (select1 == 2) {
					Spa service = new Spa();
					ID = Integer.parseInt(JOptionPane.showInputDialog("Type the reservation ID to credit this service:"));
					service.setCustomerID(ID);
					loopCheck4 = false;
					while(!loopCheck4) {
						try {
							days = Integer.parseInt(JOptionPane.showInputDialog("How many days?"));
							loopCheck4 = true;
						}
						catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Error: You must enter an integer");
						}
					}
					service.setDays(days);
					service.calculateService();
					allServices.add(service);
					calculableList.add(service);
				}
        	}
        });
        
        // Display Reservations Button
        displayReservationsButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		String print = "";
        		
        		for(int i = 0; allServices.size()>i; i++) {
					if(allServices.get(i) == null) {
						continue;
					}
					else if (allServices.get(i) instanceof ReservationSystemMain){ 
						print += (((ReservationSystemMain) allServices.get(i)).toString() );
					}
				}
        		textArea.setText(print);
        	}
        });
        
        // Display Extra Services Button
        displayExtraServicesButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		String print = "";
        		for(int i = 0; allServices.size()>i; i++) {
					if(allServices.get(i) == null) {
						continue;
					}
					else if (allServices.get(i) instanceof ReservationSystemMain) {
						continue;
					}
					else if (allServices.get(i) instanceof Spa){
						print += String.format("Reservation ID #%d has %d days of SPA services.\n", allServices.get(i).getCustomerID(), ((Spa) allServices.get(i)).getDays());
					}
					else {
						print += String.format("Reservation ID #%d has %d pieces assigned for Laundry Service.\n", allServices.get(i).getCustomerID(), ((Laundry) allServices.get(i)).getClothingPieces());
					}
				}
        		textArea.setText(print);
        	}
        });
        
        
        // Disp. Res. For City Button
        dispResForCity.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		String print = "";
        		String cityForDisp;
        		List<ReservationSystemMain> tempList2 = new ArrayList<>();
				for( Calculable reservationItem : calculableList) {
					if (reservationItem instanceof ReservationSystemMain) { 
						tempList2.add( (ReservationSystemMain) reservationItem);
					}
				}

				Collections.sort(tempList2);
				
				cityForDisp = JOptionPane.showInputDialog("Enter City");
				
				for(int i = 0; tempList2.size()>i; i++) {
					if(tempList2.get(i).getCityName().equals(cityForDisp)) {
						print += String.format("Reservation for %s\n", tempList2.get(i).getCityName());
						print += tempList2.get(i).toString();
					}
				}
				textArea.setText(print);
        	}
        });
        
        // Multithread Search Button
        multiSearchButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		if(allServices.size() >= 8) {
        			
        			searchByHotelName = JOptionPane.showInputDialog("Enter Hotel Name:");
        			
        	        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 is number of threads

        	        ConcurrentLinkedQueue<String> searchResults = new ConcurrentLinkedQueue<>();
  
        	        for (Services service : allServices) {
        	            executor.submit(() -> {
        	                if (((ReservationSystemMain) service).getHotelName().contains(searchByHotelName)) {
        	                    searchResults.add(String.valueOf(((ReservationSystemMain) service).getCustomerID()));
        	                }
        	            });
        	        }

        	        executor.shutdown();
        	        try {
        	            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        	        } catch (InterruptedException e) {
        	            e.printStackTrace();
        	        }
        	        
        	        String print = "";
            		
            		for(String id : searchResults) {
            			print+=(id+" ");
            		}
            		textArea.setText(print);
        	        
        	        
        		}
        		else {
        			String myMessage = String.format("Please enter at least 8 reservations - now it is only %d", allServices.size());
                	JOptionPane.showMessageDialog(null, myMessage, "Message", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        
        // Save Reservations Button
        saveReserv.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		if(loadClicked) { // if loadClicked once, i delete content from txt not to append same data
        			FileWriter fileWriter1;
					try {
						fileWriter1 = new FileWriter(CSV_FILE_PATH);
	                    fileWriter1.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
        		}
        		try {
                    FileWriter writer = new FileWriter(CSV_FILE_PATH, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    for(Services service : allServices) {
                    	if(service instanceof ReservationSystemMain) {
                    		ReservationSystemMain temp = (ReservationSystemMain) service;
                    		bufferedWriter.write("CityName,HotelName,ReservationMonth,ReservationStart,ReservationEnd");
    	                    bufferedWriter.newLine();
    	                    bufferedWriter.write(temp.getCityName() + "," + temp.getHotelName() + "," + temp.getReservationMonth() + ","
    	                    		+ temp.getReservationStart() + "," + temp.getReservationEnd());
    	                    bufferedWriter.newLine();   	                    
                    	}
                    }
                	JOptionPane.showMessageDialog(null, "Saved", "Message", JOptionPane.INFORMATION_MESSAGE);
                    bufferedWriter.close();
                }
        		catch (IOException e) {
                    e.printStackTrace();
                }
        		

        		
        		
        		
        	}
        });
        
        // Load Reservations Button
        loadReserv.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		if(!loadClicked) {
	        		try {
	                    FileReader reader = new FileReader(CSV_FILE_PATH);
	                    BufferedReader bufferedReader = new BufferedReader(reader);
	                    String line;
	                    while ((line = bufferedReader.readLine()) != null) {
	                        String[] fields = line.split(",");
	                        if (fields.length == 5 && !fields[0].equals("CityName")) {
	                            cityName = fields[0];
	                            hotelName = fields[1];
	                            reservationMonth = fields[2];
	                            String tempReservationStart = fields[3];
	                            String tempReservationEnd = fields[4];
	                            reservationStart = Integer.valueOf(tempReservationStart);
	                            reservationEnd = Integer.valueOf(tempReservationEnd);
	                            ReservationSystemMain newReservation = new ReservationSystemMain(cityName, hotelName, reservationMonth
	            						, reservationStart, reservationEnd);
	            				newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
	            				allServices.add(newReservation);	
	            				calculableList.add(newReservation);
	                        	loadClicked = true;
	                        }
	                    }
	                    
	                    bufferedReader.close();
	                }
	        		catch (IOException e) {
	                    e.printStackTrace();
	                }
	        		
	        		String print1 ="";
	        		for(int i = 0; allServices.size()>i; i++) {
						if(allServices.get(i) == null) {
							continue;
						}
						else if (allServices.get(i) instanceof ReservationSystemMain){ 
							print1 += (((ReservationSystemMain) allServices.get(i)).toString() );
						}
					}
	        		textArea.setText(print1);
        		}
        	}
        });
        
        // Help -> Contents
        itemContents.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String contents = "You can exit from application via menu bar 'File'->'Exit'\n"
            			+"You can add your reservation and services via menu bar 'New'\n"
            			+"You can do operations via buttons";
            	JOptionPane.showMessageDialog(null, contents, "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Help -> About
        itemAbout.addActionListener(new java.awt.event.ActionListener() {
        	
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		String about = "This is a Hotel Reservation System application which is developed by Ali Sencer Irmak";
            	JOptionPane.showMessageDialog(null, about, "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		*/        
		do {
			for(MenuOptions opts: MenuOptions.values()) {
				System.out.println(opts.getOption());
			}
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			input.nextLine();
			if (choice == 1) {		
					System.out.printf("Room Info:\n\n" + "Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false\r\n"
							+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false\r\n"
							+ "Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true\r\n"
							+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false\r\n"
							+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true\r\n"
							+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true\r\n");
					System.out.println("\nHotel Name: ");
					hotelName = input.nextLine();
					boolean loopCheck1 = false;
					while(!loopCheck1) {
						try {
							System.out.println("\nRoom Type: ");
							roomType = input.nextLine();
							if( !(roomNames.contains(roomType))) {
								throw new RoomTypeException("\nRoom Type is not valid\n");
							}
							else loopCheck1 = true;
						}
						catch(RoomTypeException e) {
							System.err.println(e.getMessage());
						}
					}
					
					System.out.println("\nReservation Month: ");
					reservationMonth = input.nextLine();
					boolean loopCheck2 = false;
					while(!loopCheck2) {
						try {
							System.out.println("\nReservation Start: ");
							reservationStart = input.nextInt();
							loopCheck2 = true;
						}
						catch(InputMismatchException e) {
							System.err.println("Reservation Start must be a numeric value!\n");
							input.next();
						}
					}
					boolean loopCheck3 = false;
					while(!loopCheck3) {
						try {
							System.out.println("\nReservation End: ");
							reservationEnd = input.nextInt();
							loopCheck3 = true;
						}
						catch(InputMismatchException e) {
							System.err.println("Reservation End must be a numeric value!\n");
							input.next();
						}
					}
					
					while(reservationEnd - reservationStart > 30) { // not to enter more than 30 days
						System.out.println("\nThe maximum possible reservation period is 30 days.");
						System.out.println("\nPlease enter the Reservation Start: ");
						reservationStart = input.nextInt();
						input.nextLine();
						
						System.out.println("\nPlease enter the Reservation End: ");
						reservationEnd = input.nextInt();
						input.nextLine();
					}
					
					if (roomType.equals("Single")) {
						Single newRoom = new Single();
						ReservationSystemMain newReservation = new ReservationSystemMain(hotelName, reservationMonth
								, reservationStart, reservationEnd, newRoom);
						newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
						allServices.add(newReservation);	
						calculableList.add(newReservation);
					}
					else if (roomType.equals("Double")) { 
						Double newRoom = new Double();
						ReservationSystemMain newReservation = new ReservationSystemMain(hotelName, reservationMonth
								, reservationStart, reservationEnd, newRoom);
						newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
						allServices.add(newReservation);
						calculableList.add(newReservation);
					}
					else if (roomType.equals("Club")) { 
						Club newRoom = new Club();
						ReservationSystemMain newReservation = new ReservationSystemMain(hotelName, reservationMonth
								, reservationStart, reservationEnd, newRoom);
						newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
						allServices.add(newReservation);
						calculableList.add(newReservation);
					}
					else if (roomType.equals("Family")) { 
						Family newRoom = new Family();
						ReservationSystemMain newReservation = new ReservationSystemMain(hotelName, reservationMonth
								, reservationStart, reservationEnd, newRoom);
						newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
						allServices.add(newReservation);
						calculableList.add(newReservation);
					}
					else if (roomType.equals("FamilyView")) { 
						FamilyView newRoom = new FamilyView();
						ReservationSystemMain newReservation = new ReservationSystemMain(hotelName, reservationMonth
								, reservationStart, reservationEnd, newRoom);
						newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
						allServices.add(newReservation);
						calculableList.add(newReservation);
					}
					else if (roomType.equals("Suite")) { 
						Suite newRoom = new Suite();
						ReservationSystemMain newReservation = new ReservationSystemMain(hotelName, reservationMonth
								, reservationStart, reservationEnd, newRoom);
						newReservation.setCustomerID(++ReservationSystemMain.totalNumberOfReservations);
						allServices.add(newReservation);
						calculableList.add(newReservation);
					}
					System.out.printf("\nReservation ID: %d is created!\n\n", ReservationSystemMain.totalNumberOfReservations);
				
			}
			else if (choice == 2) {
				for(int i = 0; allServices.size()>i; i++) {
					if(allServices.get(i) == null) {
						continue;
					}
					else if (allServices.get(i) instanceof ReservationSystemMain){ 
						((ReservationSystemMain) allServices.get(i)).displayInfo();
					}
				}
			}
			
			else if (choice == 3) {
				System.out.println("Type a city name for a reservation search: ");
				CitySpecific = input.nextLine();
				List< Services > list = new ArrayList< Services >();
				for( Services cities : allServices) {
					if (cities instanceof ReservationSystemMain) { 
						list.add(cities);
					}
				}
				Iterator<Services> itr = list.iterator();
				int i=0;
				while(itr.hasNext()){
					if(((ReservationSystemMain) itr.next()).getHotelName().contains(CitySpecific)) {
						System.out.println(( (ReservationSystemMain) list.get(i)).getHotelName());
					}
					i++;
				}
			}
			else if (choice == 4) {
				int select1 = 0, ID = 0, piecesOfClothing = 0, days = 0;
				boolean loopCheck4 = false;
				System.out.println("Please select one of the extra services from below:");
				System.out.println("1. Laundry Service\n2. Spa Service");
				select1 = input.nextInt();
				input.nextLine();		
				if (select1 == 1) {
					Laundry service = new Laundry();
					System.out.println("Type the reservation ID to credit this service:");
					ID = input.nextInt();
					input.nextLine();		
					service.setCustomerID(ID);
					loopCheck4 = false;
					while(!loopCheck4) {
						try {
							System.out.println("How many pieces of clothing?");
							piecesOfClothing = input.nextInt();
							loopCheck4 = true;
						}
						catch(InputMismatchException e) {
							System.err.println("Clothing count must be a numeric value!\n");
							input.nextLine();
						}
					}
					service.setClothingPieces(piecesOfClothing);
					service.calculateService();
					allServices.add(service);
					calculableList.add(service);
				}
				else if (select1 == 2) {
					Spa service = new Spa();
					System.out.println("Type the reservation ID to credit this service:");
					ID = input.nextInt();
					input.nextLine();
					service.setCustomerID(ID);
					loopCheck4 = false;
					while(!loopCheck4) {
						try {
							System.out.println("How many days?");
							days = input.nextInt();
							loopCheck4 = true;
						}
						catch(InputMismatchException e) {
							System.err.println("Day count must be a numeric value!");
							input.nextLine();
						}
					}
					service.setDays(days);
					service.calculateService();
					allServices.add(service);
					calculableList.add(service);
				}
			}
			else if (choice == 5) {
				for(int i = 0; allServices.size()>i; i++) {
					if(allServices.get(i) == null) {
						continue;
					}
					else if (allServices.get(i) instanceof ReservationSystemMain) {
						System.out.printf("The cost for the Room booking service of reservation ID %d: %.2f\n\n",
								((ReservationSystemMain) allServices.get(i)).getCustomerID(), ((ReservationSystemMain) allServices.get(i)).calculateService());
					}
					else {
						System.out.printf("The Cost for the %s service of reservation ID %d: %.2f\n\n",allServices.get(i).getServiceType(), 
								allServices.get(i).getCustomerID(), allServices.get(i).calculateService());
					}
				}
			}
			else if (choice == 6) {
				double totalCost = 0;
				for(int i = 0; allServices.size()>i; i++) {
					if (allServices.get(i) instanceof ReservationSystemMain) {
						totalCost+=allServices.get(i).calculateService();
						for(int j = i+1; allServices.size()>j; j++) {
							if(allServices.get(j).getCustomerID() == allServices.get(i).getCustomerID()) {
								totalCost+=allServices.get(j).calculateService();
							}
						}
						System.out.printf("The total cost of all services of the reservation with ID: %d is %.2f\n\n", 
								allServices.get(i).getCustomerID(), totalCost);
						totalCost = 0;
					}
				}
			}
			else if (choice == 7) {
				String name, surname;
				double monthlyPayment = 0;
				int id;
				System.out.println("Name: ");
				name = input.nextLine();
				System.out.println("Surname: ");
				surname = input.nextLine();
				System.out.println("ID: ");
				id = input.nextInt();
				input.nextLine();
				boolean loopCheck6 = false;
				while(!loopCheck6) {
					try {
						System.out.println("Monthly Payment: ");
						monthlyPayment = input.nextDouble();
						input.nextLine();
						loopCheck6 = true;
					}catch(InputMismatchException e) {
						System.err.println("Monthly Payment must be a numeric value!");
						input.nextLine();
					}
				}
				
				Employees employee = new Employees(name, surname, id, monthlyPayment);
				calculableList.add(employee);
			}
			else if (choice == 8) {
				String type, month;
				double amount = 0;
				System.out.println("Type: ");
				type = input.nextLine();
				boolean loopCheck5 = false;
				while(!loopCheck5) {
					try {
						System.out.println("Amount: ");
						amount = input.nextDouble();
						input.nextLine();
						loopCheck5 = true;
					}catch(InputMismatchException e) {
						System.err.println("Bill Amount must be a numeric value!");
						input.nextLine();
					}
				}
				System.out.println("Month: ");
				month = input.nextLine();
				Bills bill = new Bills(type, month, amount);
				calculableList.add(bill);
			}
			else if (choice == 9) {
				String month;
				double income = 0, billOutcome = 0, employeeOutcome = 0;
				System.out.println("Enter Month: ");
				month = input.nextLine();
				for(int i = 0; calculableList.size()>i; i++) {
					if(calculableList.get(i) == null) {
						continue;
					}
					else if (calculableList.get(i) instanceof ReservationSystemMain){ 
						if( ((ReservationSystemMain) calculableList.get(i)).getReservationMonth().equals(month) ) {
							for(int j = 0; calculableList.size()>j; j++) {
								if(calculableList.get(j) == null) {
									continue;
								}
								else if ( calculableList.get(j) instanceof Services && ((Services) calculableList.get(j)).CustomerID == ((ReservationSystemMain) calculableList.get(i)).CustomerID ){
									System.out.printf("For reservation ID: %d, Service type: %s, Service Cost: %.2f\n",
											((Services) calculableList.get(j)).CustomerID, ((Services) calculableList.get(j)).getServiceType(), ((Services) calculableList.get(j)).calculateService());
									income+= ((Services) calculableList.get(j)).calculateService();
								}
							}
						}
					}
				}
				for(int k = 0; calculableList.size()>k; k++) {
					if(calculableList.get(k) instanceof Bills) {
						if( ((Bills) calculableList.get(k)).getMonth().equals(month) ) {
							billOutcome+=calculableList.get(k).getCost();
						}
					}
					else if (calculableList.get(k) instanceof Employees)
						employeeOutcome+=calculableList.get(k).getCost();
				}
					
				System.out.printf("Total monthly income: %.2f\n", income);
				System.out.printf("Total bills due: %.2f\n", billOutcome);
				System.out.printf("Total employee due: %.2f\n", employeeOutcome);
				System.out.printf("End of month balance: %.2f\n", income-billOutcome-employeeOutcome);		
			}
			else if (choice == 10) {
				
				List<Services> tempList = new ArrayList<>();
				for( Calculable serviceItem : calculableList) {
					if (serviceItem instanceof Services) { 
						tempList.add( (Services) serviceItem);
					}
				}
				Collections.sort(tempList, new CostComparator());
				
				for(int i = 0; tempList.size()>i; i++) {
					tempList.get(i).displayServiceInfo();
				}
				
			}
			else if (choice == 11) {
				List<ReservationSystemMain> tempList2 = new ArrayList<>();
				for( Calculable reservationItem : calculableList) {
					if (reservationItem instanceof ReservationSystemMain) { 
						tempList2.add( (ReservationSystemMain) reservationItem);
					}
				}

				Collections.sort(tempList2);
				
				for(int i = 0; tempList2.size()>i; i++) {
					System.out.print("Hotel Name: " + tempList2.get(i).getHotelName() + ", ");
					tempList2.get(i).displayServiceInfo();
				}
			}
			else if (choice == 12) {
				System.out.println("Exiting, Goodbye!");
				loopCheck = false;
			}
			else if(choice-12>0 || choice<0) {
				System.err.println("You entered an invalid menu option. Enter again.");
				loopCheck = true;
			}
		}while(loopCheck);

	}
}
