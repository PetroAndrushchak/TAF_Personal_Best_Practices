#!/bin/bash
until [ -f /tmp/openvpn.log ] && [ "$(grep -c "Initialization Sequence Completed" /tmp/openvpn.log)" != 0 ]; do
   echo "Attempting to connect to VPN server..."
  sleep 1;
done

         printf "\nVPN connected\n"
              printf "\nPublic IP is now $(curl checkip.amazonaws.com)\n"