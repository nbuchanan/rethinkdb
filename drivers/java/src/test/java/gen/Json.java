// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../templates/Test.java
package gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.*;
import com.rethinkdb.gen.ast.*;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.Collections;
import java.nio.charset.StandardCharsets;

import static gen.TestingCommon.*;
import gen.TestingFramework;

public class Json {
    Logger logger = LoggerFactory.getLogger(Json.class);
    public static final RethinkDB r = RethinkDB.r;

    Connection<?> conn;
    public String hostname = TestingFramework.getConfig().getHostName();
    public int port = TestingFramework.getConfig().getPort();

    @Before
    public void setUp() throws Exception {
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down.");
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.dbDrop("test").run(conn);
        r.db("rethinkdb").table("_debug_scratch").delete();
        conn.close(false);
    }

    // Autogenerated tests below

        @Test(timeout=120000)
    public void test() throws Exception {
                
        {
            // json.yaml #1
            /* [1, 2, 3] */
            List expected_ = r.array(1L, 2L, 3L);
            /* r.json("[1,2,3]") */
            System.out.println("About to run #1: r.json('[1,2,3]')");
            Object obtained = runOrCatch(r.json("[1,2,3]"),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #1");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #1");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #1:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #2
            /* 1 */
            Long expected_ = 1L;
            /* r.json("1") */
            System.out.println("About to run #2: r.json('1')");
            Object obtained = runOrCatch(r.json("1"),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #2");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #2");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #2:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #3
            /* {} */
            Map expected_ = r.hashMap();
            /* r.json("{}") */
            System.out.println("About to run #3: r.json('{}')");
            Object obtained = runOrCatch(r.json("{}"),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #3");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #3");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #3:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #4
            /* "foo" */
            String expected_ = "foo";
            /* r.json('"foo"') */
            System.out.println("About to run #4: r.json('\\'foo\\'')");
            Object obtained = runOrCatch(r.json("\"foo\""),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #4");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #4");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #4:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #5
            /* err("ReqlQueryLogicError", 'Failed to parse "[1,2" as JSON:' + ' Missing a comma or \']\' after an array element.', [0]) */
            Err expected_ = err("ReqlQueryLogicError", "Failed to parse \"[1,2\" as JSON:" + " Missing a comma or ']' after an array element.", r.array(0L));
            /* r.json("[1,2") */
            System.out.println("About to run #5: r.json('[1,2')");
            Object obtained = runOrCatch(r.json("[1,2"),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #5");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #5");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #5:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #6
            /* ('[1,2,3]') */
            String expected_ = "[1,2,3]";
            /* r.json("[1,2,3]").to_json_string() */
            System.out.println("About to run #6: r.json('[1,2,3]').toJsonString()");
            Object obtained = runOrCatch(r.json("[1,2,3]").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #6");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #6");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #6:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #7
            /* ('[1,2,3]') */
            String expected_ = "[1,2,3]";
            /* r.json("[1,2,3]").to_json() */
            System.out.println("About to run #7: r.json('[1,2,3]').toJson()");
            Object obtained = runOrCatch(r.json("[1,2,3]").toJson(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #7");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #7");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #7:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #8
            /* ('{"foo":4}') */
            String expected_ = "{\"foo\":4}";
            /* r.json("{\"foo\":4}").to_json_string() */
            System.out.println("About to run #8: r.json('{\\'foo\\':4}').toJsonString()");
            Object obtained = runOrCatch(r.json("{\"foo\":4}").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #8");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #8");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #8:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #9
            /* ('{"foo":4}') */
            String expected_ = "{\"foo\":4}";
            /* r.json("{\"foo\":4}").to_json() */
            System.out.println("About to run #9: r.json('{\\'foo\\':4}').toJson()");
            Object obtained = runOrCatch(r.json("{\"foo\":4}").toJson(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #9");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #9");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #9:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        // json.yaml #10
        // text = '[{"id":1,"first_name":"Harry","last_name":"Riley","email":"hriley0@usgs.gov","country":"Andorra","ip_address":"221.25.65.136"},{"id":2,"first_name":"Bonnie","last_name":"Anderson","email":"banderson1@list-manage.com","country":"Tuvalu","ip_address":"116.162.43.150"},{"id":3,"first_name":"Marie","last_name":"Schmidt","email":"mschmidt2@diigo.com","country":"Iraq","ip_address":"181.105.59.57"},{"id":4,"first_name":"Phillip","last_name":"Willis","email":"pwillis3@com.com","country":"Montenegro","ip_address":"24.223.139.156"}]'
        System.out.println("Possibly executing: String text = (String) ('[{\\'id\\':1,\\'first_name\\':\\'Harry\\',\\'last_name\\':\\'Riley\\',\\'email\\':\\'hriley0@usgs.gov\\',\\'country\\':\\'Andorra\\',\\'ip_address\\':\\'221.25.65.136\\'},{\\'id\\':2,\\'first_name\\':\\'Bonnie\\',\\'last_name\\':\\'Anderson\\',\\'email\\':\\'banderson1@list-manage.com\\',\\'country\\':\\'Tuvalu\\',\\'ip_address\\':\\'116.162.43.150\\'},{\\'id\\':3,\\'first_name\\':\\'Marie\\',\\'last_name\\':\\'Schmidt\\',\\'email\\':\\'mschmidt2@diigo.com\\',\\'country\\':\\'Iraq\\',\\'ip_address\\':\\'181.105.59.57\\'},{\\'id\\':4,\\'first_name\\':\\'Phillip\\',\\'last_name\\':\\'Willis\\',\\'email\\':\\'pwillis3@com.com\\',\\'country\\':\\'Montenegro\\',\\'ip_address\\':\\'24.223.139.156\\'}]');");
        String text = (String) ("[{\"id\":1,\"first_name\":\"Harry\",\"last_name\":\"Riley\",\"email\":\"hriley0@usgs.gov\",\"country\":\"Andorra\",\"ip_address\":\"221.25.65.136\"},{\"id\":2,\"first_name\":\"Bonnie\",\"last_name\":\"Anderson\",\"email\":\"banderson1@list-manage.com\",\"country\":\"Tuvalu\",\"ip_address\":\"116.162.43.150\"},{\"id\":3,\"first_name\":\"Marie\",\"last_name\":\"Schmidt\",\"email\":\"mschmidt2@diigo.com\",\"country\":\"Iraq\",\"ip_address\":\"181.105.59.57\"},{\"id\":4,\"first_name\":\"Phillip\",\"last_name\":\"Willis\",\"email\":\"pwillis3@com.com\",\"country\":\"Montenegro\",\"ip_address\":\"24.223.139.156\"}]");
                
        // json.yaml #11
        // sorted = '[{"country":"Andorra","email":"hriley0@usgs.gov","first_name":"Harry","id":1,"ip_address":"221.25.65.136","last_name":"Riley"},{"country":"Tuvalu","email":"banderson1@list-manage.com","first_name":"Bonnie","id":2,"ip_address":"116.162.43.150","last_name":"Anderson"},{"country":"Iraq","email":"mschmidt2@diigo.com","first_name":"Marie","id":3,"ip_address":"181.105.59.57","last_name":"Schmidt"},{"country":"Montenegro","email":"pwillis3@com.com","first_name":"Phillip","id":4,"ip_address":"24.223.139.156","last_name":"Willis"}]'
        System.out.println("Possibly executing: String sorted = (String) ('[{\\'country\\':\\'Andorra\\',\\'email\\':\\'hriley0@usgs.gov\\',\\'first_name\\':\\'Harry\\',\\'id\\':1,\\'ip_address\\':\\'221.25.65.136\\',\\'last_name\\':\\'Riley\\'},{\\'country\\':\\'Tuvalu\\',\\'email\\':\\'banderson1@list-manage.com\\',\\'first_name\\':\\'Bonnie\\',\\'id\\':2,\\'ip_address\\':\\'116.162.43.150\\',\\'last_name\\':\\'Anderson\\'},{\\'country\\':\\'Iraq\\',\\'email\\':\\'mschmidt2@diigo.com\\',\\'first_name\\':\\'Marie\\',\\'id\\':3,\\'ip_address\\':\\'181.105.59.57\\',\\'last_name\\':\\'Schmidt\\'},{\\'country\\':\\'Montenegro\\',\\'email\\':\\'pwillis3@com.com\\',\\'first_name\\':\\'Phillip\\',\\'id\\':4,\\'ip_address\\':\\'24.223.139.156\\',\\'last_name\\':\\'Willis\\'}]');");
        String sorted = (String) ("[{\"country\":\"Andorra\",\"email\":\"hriley0@usgs.gov\",\"first_name\":\"Harry\",\"id\":1,\"ip_address\":\"221.25.65.136\",\"last_name\":\"Riley\"},{\"country\":\"Tuvalu\",\"email\":\"banderson1@list-manage.com\",\"first_name\":\"Bonnie\",\"id\":2,\"ip_address\":\"116.162.43.150\",\"last_name\":\"Anderson\"},{\"country\":\"Iraq\",\"email\":\"mschmidt2@diigo.com\",\"first_name\":\"Marie\",\"id\":3,\"ip_address\":\"181.105.59.57\",\"last_name\":\"Schmidt\"},{\"country\":\"Montenegro\",\"email\":\"pwillis3@com.com\",\"first_name\":\"Phillip\",\"id\":4,\"ip_address\":\"24.223.139.156\",\"last_name\":\"Willis\"}]");
                
        {
            // json.yaml #12
            /* sorted */
            String expected_ = sorted;
            /* r.json(text).to_json_string() */
            System.out.println("About to run #12: r.json(text).toJsonString()");
            Object obtained = runOrCatch(r.json(text).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #12");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #12");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #12:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #13
            /* err('ReqlQueryLogicError', 'Cannot convert `r.minval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.minval` to JSON.");
            /* r.expr(r.minval).to_json_string() */
            System.out.println("About to run #13: r.expr(r.minval()).toJsonString()");
            Object obtained = runOrCatch(r.expr(r.minval()).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #13");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #13");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #13:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #14
            /* err('ReqlQueryLogicError', 'Cannot convert `r.maxval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.maxval` to JSON.");
            /* r.expr(r.maxval).to_json_string() */
            System.out.println("About to run #14: r.expr(r.maxval()).toJsonString()");
            Object obtained = runOrCatch(r.expr(r.maxval()).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #14");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #14");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #14:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #15
            /* err('ReqlQueryLogicError', 'Cannot convert `r.minval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.minval` to JSON.");
            /* r.expr(r.minval).coerce_to('string') */
            System.out.println("About to run #15: r.expr(r.minval()).coerceTo('string')");
            Object obtained = runOrCatch(r.expr(r.minval()).coerceTo("string"),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #15");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #15");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #15:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #16
            /* err('ReqlQueryLogicError', 'Cannot convert `r.maxval` to JSON.') */
            Err expected_ = err("ReqlQueryLogicError", "Cannot convert `r.maxval` to JSON.");
            /* r.expr(r.maxval).coerce_to('string') */
            System.out.println("About to run #16: r.expr(r.maxval()).coerceTo('string')");
            Object obtained = runOrCatch(r.expr(r.maxval()).coerceTo("string"),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #16");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #16");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #16:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #17
            /* ({'timezone':'+00:00','$reql_type$':'TIME','epoch_time':1410393600}) */
            Map expected_ = r.hashMap("timezone", "+00:00").with("$reql_type$", "TIME").with("epoch_time", 1410393600L);
            /* r.time(2014,9,11, 'Z') */
            System.out.println("About to run #17: r.time(2014L, 9L, 11L, 'Z')");
            Object obtained = runOrCatch(r.time(2014L, 9L, 11L, "Z"),
                                          new OptArgs()
                                          .with("time_format", "raw")
                                          ,conn);
            System.out.println("Finished running #17");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #17");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #17:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #18
            /* ('{"$reql_type$":"TIME","epoch_time":1410393600,"timezone":"+00:00"}') */
            String expected_ = "{\"$reql_type$\":\"TIME\",\"epoch_time\":1410393600,\"timezone\":\"+00:00\"}";
            /* r.time(2014,9,11, 'Z').to_json_string() */
            System.out.println("About to run #18: r.time(2014L, 9L, 11L, 'Z').toJsonString()");
            Object obtained = runOrCatch(r.time(2014L, 9L, 11L, "Z").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #18");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #18");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #18:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #19
            /* ({'$reql_type$':'GEOMETRY','coordinates':[0,0],'type':'Point'}) */
            Map expected_ = r.hashMap("$reql_type$", "GEOMETRY").with("coordinates", r.array(0L, 0L)).with("type", "Point");
            /* r.point(0,0) */
            System.out.println("About to run #19: r.point(0L, 0L)");
            Object obtained = runOrCatch(r.point(0L, 0L),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #19");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #19");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #19:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #20
            /* ('{"$reql_type$":"GEOMETRY","coordinates":[0,0],"type":"Point"}') */
            String expected_ = "{\"$reql_type$\":\"GEOMETRY\",\"coordinates\":[0,0],\"type\":\"Point\"}";
            /* r.point(0,0).to_json_string() */
            System.out.println("About to run #20: r.point(0L, 0L).toJsonString()");
            Object obtained = runOrCatch(r.point(0L, 0L).toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #20");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #20");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #20:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        // json.yaml #21
        // s = b'\x66\x6f\x6f'
        System.out.println("Possibly executing: byte[] s = (byte[]) (new byte[]{102, 111, 111});");
        byte[] s = (byte[]) (new byte[]{102, 111, 111});
                
        {
            // json.yaml #22
            /* (s) */
            byte[] expected_ = s;
            /* r.binary(s) */
            System.out.println("About to run #22: r.binary(s)");
            Object obtained = runOrCatch(r.binary(s),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #22");
            try {
                assertArrayEquals(expected_, (byte[]) obtained);
            System.out.println("Finished asserting #22");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #22:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // json.yaml #23
            /* ('{"$reql_type$":"BINARY","data":"Zm9v"}') */
            String expected_ = "{\"$reql_type$\":\"BINARY\",\"data\":\"Zm9v\"}";
            /* r.expr("foo").coerce_to("binary").to_json_string() */
            System.out.println("About to run #23: r.expr('foo').coerceTo('binary').toJsonString()");
            Object obtained = runOrCatch(r.expr("foo").coerceTo("binary").toJsonString(),
                                          new OptArgs()
                                          ,conn);
            System.out.println("Finished running #23");
            try {
                assertEquals(expected_, obtained);
            System.out.println("Finished asserting #23");
            } catch (Throwable ae) {
                System.out.println("Whoops, got exception on #23:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}