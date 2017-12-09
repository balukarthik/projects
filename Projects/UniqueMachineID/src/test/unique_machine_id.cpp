#include <unique_machine_id.h>

#include <gtest/gtest.h>

using namespace balukarthik;

// this is incomplete
TEST(UniqueMachineIDSuite, UniqueMachineIDTest) {
  
  UniqueMachineID umid;

  printf("Machine ID: %s\n", umid.get().c_str());

//  ASSERT_ANY_THROW();
}


