import java.util.Scanner;

public class SubnettingPr_5 {

    // Method to find class of the IP address
    public void findClass(String ip) {
        String[] parts = ip.split("\\.");
        
        // Check if the IP has 4 octets
        if (parts.length != 4) {
            System.out.println("Invalid IP address. It should be in the format xxx.xxx.xxx.xxx");
            return;
        }

        try {
            int firstOctet = Integer.parseInt(parts[0]);

            // Determine the class of the IP address based on the first octet
            if (firstOctet >= 1 && firstOctet <= 126) {
                System.out.println("Class A");
                System.out.println("Default Subnet Mask: 255.0.0.0");
            } else if (firstOctet >= 128 && firstOctet <= 191) {
                System.out.println("Class B");
                System.out.println("Default Subnet Mask: 255.255.0.0");
            } else if (firstOctet >= 192 && firstOctet <= 223) {
                System.out.println("Class C");
                System.out.println("Default Subnet Mask: 255.255.255.0");
            } else if (firstOctet >= 224 && firstOctet <= 239) {
                System.out.println("Class D (Multicast Address)");
            } else if (firstOctet >= 240 && firstOctet <= 254) {
                System.out.println("Class E (Experimental Address)");
            } else {
                System.out.println("Invalid IP Address");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid IP address. Octets must be numeric.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubnettingPr_5 subnetting = new SubnettingPr_5();

        // Get IP address from user
        System.out.print("Enter the IP Address (e.g., 192.168.1.1): ");
        String ipAddress = sc.nextLine();

        // Call method to find the class and default subnet mask
        subnetting.findClass(ipAddress);

        sc.close();
    }
}
