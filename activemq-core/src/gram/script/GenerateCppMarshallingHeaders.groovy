/**
 *
 * Copyright 2005-2006 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.apache.activemq.openwire.tool.OpenWireCppMarshallingHeadersScript

/**
 * Generates the C++ marshalling headers for the Open Wire Format
 *
 * @version $Revision$
 */
class GenerateCppMarshallingHeaders extends OpenWireCppMarshallingHeadersScript {

 	void generateFile(PrintWriter out) {
                out << """/*
* Copyright 2006 The Apache Software Foundation or its licensors, as
* applicable.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
#ifndef ${className}_hpp_
#define ${className}_hpp_

#include <string>

#include "command/DataStructure.hpp"

/* we could cut this down  - for now include all possible headers */
#include "command/BrokerId.hpp"
#include "command/ConnectionId.hpp"
#include "command/ConsumerId.hpp"
#include "command/ProducerId.hpp"
#include "command/SessionId.hpp"

#include "io/BinaryReader.hpp"
#include "io/BinaryWriter.hpp"

#include "command/${baseClass}.hpp"
#include "util/ifr/p"

namespace apache
{
  namespace activemq
  {
    namespace client
    {
      namespace marshal
      {
        using namespace ifr ;
        using namespace apache::activemq::client::command;
        using namespace apache::activemq::client::io;

/*
 *
 */
class ${className} : public ${baseClass}
{
public:
    ${className}() ;
    virtual ~${className}() ;

    virtual DataStructure* createCommand() ;
    virtual byte getDataStructureType() ;
    
    virtual void unmarshal(OpenWireFormat& wireFormat, Object o, BinaryReader& dataIn, BooleanStream& bs) ;
    virtual int marshal1(OpenWireFormat& wireFormat, Object& o, BooleanStream& bs) ;
    virtual void marshal2(OpenWireFormat& wireFormat, Object& o, BinaryWriter& dataOut, BooleanStream& bs) ;
} ;

/* namespace */
     }
    }
  }
}
#endif /*${className}_hpp_*/
"""
        }
 	
 
    void generateFactory(PrintWriter out) {
        out << """//*
* Copyright 2006 The Apache Software Foundation or its licensors, as
* applicable.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

// Marshalling code for Open Wire Format 
//
//
// NOTE!: This file is autogenerated - do not modify!
//        if you need to make a change, please see the Groovy scripts in the
//        activemq-openwire module
//

#ifndef MarshallerFactory_hpp_
#define MarshallerFactory_hpp_


namespace apache
{
  namespace activemq
  {
    namespace client
    {
      namespace marshal
      {
        using namespace ifr ;
        using namespace std ;
        using namespace apache::activemq::client;
        using namespace apache::activemq::client::command;
        using namespace apache::activemq::client::io;

/*
 * 
 */
class MarshallerFactory
{
public:
    MarshallerFactory() ;
    virtual ~MarshallerFactory() ;

	  virtual void configure(OpenWireFormat& format) ;
} ;

/* namespace */
      }
    }
  }
}

#endif /*MarshallerFactory_hpp_*/
"""
    }
}
 	