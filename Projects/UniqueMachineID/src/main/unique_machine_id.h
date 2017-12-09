#ifndef unique_machine_id_h
#define unique_machine_id_h

#ifdef _WIN32 // WINDOWS

#include "machine_id.h"   

#define WIN32_LEAN_AND_MEAN        
#include <windows.h>      
#include <intrin.h>       
#include <iphlpapi.h>    

#endif // WINDOWS

#include <string>

namespace balukarthik 
{
  class UniqueMachineID 
  {
    public:
      UniqueMachineID();
      ~UniqueMachineID();

      std::string get();

    private:

#ifdef _WIN32 // WINDOWS

      u16 hashMacAddress(PIP_ADAPTER_INFO info);          

      void getMacHash(u16& mac1, u16& mac2);              

      u16 getVolumeHash();       

      u16 getCpuHash();

      const char* getMachineName();       

#else // !WINDOWS

      const char* getMachineName();

      unsigned short hashMacAddress( unsigned char* mac );
 
      void getMacHash( 
          unsigned short& mac1, 
          unsigned short& mac2 );

      unsigned short getVolumeHash();


#ifdef DARWIN // DARWIN
      unsigned short getCpuHash();
#else //!DARWIN
      static void getCpuId( unsigned int* p, unsigned int ax );
      unsigned short getCpuHash();
#endif // DARWIN
#endif // WINDOWS
  }; 
};

#endif


