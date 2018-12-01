package pl.sages.bank.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import pl.sages.bank.Account;
import pl.sages.bank.Bank;

import static org.assertj.core.api.Assertions.*;

public class StepConnectDefinitions {

    private Bank bank;

    @Given("^Create bank with name (.+)$")
    public void createBank(String text) {
        bank = new Bank(text);
    }

    @And("^Add account with name: (.*) ownerName: (.*) balance: (.*)$")
    public void createAccount(Long number, String ownerName, Long balance) {
        Account account = new Account(number, ownerName);
        account.setBalance(balance);
        bank.addAccount(account);
    }

    @When("^Transfer (.*) zł from (.*) to (.*)$")
    public void transfer(Long money, Long from, Long to) {
        bank.transferMoney(from, to, money);
    }

    @Then("^Account (.*) has balance: (.*)")
    public void testMoney(Long account, Long money) {
        assertThat(bank.getAccount(account).getBalance()).isEqualTo(money);
    }

//    @Given("^SoapResponse contains (.+)$")
//    public void soapResponseCointains(String text) {
//        assertThat(soapResponse).contains(text);
//    }
//
//    @Given("^Create a soap request$")
//    public void createBasicRequest() {
//        xmlBuilder.createBasicStructure(connectCallbackUrl, requestSoapUsername, requestSoapPassword);
//    }
//
//    @Given("^Create soap request with username (.+)$")
//    public void createRequestWithInvalidUsername(String username) {
//        xmlBuilder.createBasicStructure(connectCallbackUrl, username, requestSoapPassword);
//    }
//
//    @Given("^Create request with valid user and invalid password (.+)$")
//    public void createRequestWithInvalidPassword(String password) {
//        xmlBuilder.createBasicStructure(connectCallbackUrl, requestSoapUsername, password);
//    }
//
//    @And("^Create request with reply-to (.+)$")
//    public void createBasicRequestInvalidCallback(String callback) {
//        xmlBuilder.createBasicStructure(callback, requestSoapUsername, requestSoapPassword);
//    }
//
//    @And("^Add subscription id (.+) with value (.+)$")
//    public void createBasicRequest(String name, String value) {
//        curSubscriptionType = name;
//        curSubscriptionId = value;
//        xmlBuilder.addSubscriptionIds(name, value);
//    }
//
//    @And("^Add rfs with attributes:$")
//    public void addAttributesToRfs(DataTable rfsAttributes) {
//        xmlBuilder.addRfs();
//        Map<String, String> resources = rfsAttributes.asMap(String.class, String.class);
//        for (String key : resources.keySet()) {
//            log.info("Added {} = {}", key, resources.get(key));
//            xmlBuilder.addAttributes(key, resources.get(key));
//        }
//    }
//
//    @And("^Add rfs params:$")
//    public void addParamsToRfs(DataTable rfsParams) {
//        log.info("Add params: {}", rfsParams);
//        xmlBuilder.addParams(rfsParams);
//    }
//
//    @SneakyThrows
//    @When("^Soap request is sent to request endpoint$")
//    public void sendMessage() {
//        xmlBuilder.saveDocument(); // FIXME: po co ten plik jest zapisywany na dysk? aż trzeba było go do .gitingore zapisać
//        soapResponse = requestService.send(xmlBuilder.convertToString(), new URL(requestEndpointUrl));
//        log.info("Soap response is - {}", soapResponse);
//    }
//
//
//    @Then("^Request is ACK'ed by Request Endpoint$")
//    public void responseIsSuccessful() {
//        Matcher matcher = requestIdPattern.matcher(soapResponse);
//        assertThat(matcher.find()).overridingErrorMessage("Request Id not found in response. Response is - " + soapResponse).isTrue();
//        requestId = matcher.group(1);
//        matcher = correlationIdPattern.matcher(soapResponse);
//        if (matcher.find()) {
//            assertThat(matcher.group(1)).overridingErrorMessage("Correlation ID in response is not as expected").isEqualTo(OrderNo.getOrderNo());
//        } else {
//            fail(format("soapResponse [%s] doesn't match to pattern [%s]", soapResponse, requestIdPattern.pattern()));
//        }
//    }
//
//    @SneakyThrows
//    @Given("^Create soap order status request$")
//    public void createBasicOrderStatusRequest() {
//        soapRequest = testUtils.getFileText(SOAP_DIRECTORY, "orderStatus.xml");
//    }
//
//    @SneakyThrows
//    @When("^Soap order status request is sent to request endpoint$")
//    public void sendSoapOrderStatusToEndpoint() {
//        soapResponse = requestService.send(soapRequest, new URL(requestEndpointUrl));
//    }
//
//    @Then("^Order status response contains Order (.*) message and (.*) status$")
//    public void orderStatusRequestContains(String message, String status) {
//        assertThat(soapResponse).isNotBlank();
//        assertThat(soapResponse).contains(message);
//        assertThat(soapResponse).contains(status);
//    }
//
//    @Given("^Create Order Response without Errors$")
//    public void createBasicOrderResponseClean() {
//        orderResponse = new OrderResponse("123", OrderNo.generateOrderNo(), callbackApiUrl, None());
//    }
//
//    @Given("^Create Order Response without Errors for OM$")
//    public void createBasicOrderResponseWithResendOMVersion() {
//        orderResponse = new OrderResponse("123", OrderNo.generateOrderNo(), callbackResendApiUrl, None());
//    }
//
//    @Given("^Create Order Response without Errors with wrong reply-to address$")
//    public void createBasicOrderWrongAdress() {
//        orderResponse = new OrderResponse("123", OrderNo.generateOrderNo(), "http://SomeWrongAdress", None());
//
//    }
//
//    @Then("^Response was consumed from Queue by ResponseEndpoint and sent to OM callback$")
//    public void responseCallbackSent() throws Exception {
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                return Objects.equals(requestId, connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/requestId"));
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Could not find request with id [%s] in [%d] sec.", requestId, timeout / 1000));
//        connectResponse.setRequestId(connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/requestId"));
//        connectResponse.setErrorType(connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/errorType"));
//        connectResponse.setErrorMessage(connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/errorMessage"));
//        connectResponse.setErrorCode(connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/responseInfo"));
//        connectResponse.setSourceSystem(connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/sourceSystem"));
//        log.info("Request ID: {}\nError code: {}\nError type: {}\nError message: {}",
//                connectResponse.getRequestId(),
//                connectResponse.getErrorCode(),
//                connectResponse.getErrorType(),
//                connectResponse.getErrorMessage());
//
//    }
//
//    @Then("^Response was taken from Queue and sent to OM and ResponseEndpoint receives RESEND as callback$")
//    public void responseCallbackSentToResendOM() throws Exception {
//
//        Thread.sleep(3 * resendMessageTtl + 2000);
//
//        connectResponse.setRequestId(connectCallbackApi.getConnectCallback(callbackResendRestApiUrl + "/requestId"));
//        assertThat(connectResponse.getRequestId()).isEqualTo(OrderNo.getOrderNo());
//
//    }
//
//    @Then("^Response was taken from Queue and didn't send to OM$")
//    public void responseCallbackSentToWrongUrl() throws Exception {
//
//        Thread.sleep(3 * resendMessageTtl + 2000); // time of QUEUE TLL
//
//        connectResponse.setRequestId(connectCallbackApi.getConnectCallback(callbackRestApiUrl + "/requestId"));
//        assertThat(connectResponse.getRequestId()).isNotEqualTo(OrderNo.getOrderNo());
//
//    }
//
//    @And("^OrderResponse was received by OM$")
//    public void callbackExists() {
//        assertThat(connectResponse.getRequestId()).isNotBlank();
//    }
//
//    @And("^OM callback receives OrderResponse with no errors$")
//    public void callbackHasNoErrors() {
//        assertThat(connectResponse.getErrorCode()).isBlank();
//        assertThat(connectResponse.getErrorMessage()).isBlank();
//        assertThat(connectResponse.getErrorType()).isBlank();
//    }
//
//    @And("^OM callback receives OrderResponse with errors$")
//    public void callbackHasErrors() {
//        assertThat(connectResponse.getErrorCode()).isNotBlank();
//        assertThat(connectResponse.getErrorMessage()).isNotBlank();
//        assertThat(connectResponse.getErrorType()).isNotBlank();
//    }
//
//    @And("^OM callback receives OrderResponse with error type (.*) and error code (.*)$")
//    public void callbackErrorsAre(String errorType, String errorCode) {
//        String actualErrorType = connectResponse.getErrorType();
//        assertThat(actualErrorType)
//                .overridingErrorMessage("Error type is not as expected. Error type is - " + actualErrorType)
//                .isEqualTo(errorType);
//
//        String actualErrorCode = connectResponse.getErrorCode();
//        assertThat(actualErrorCode)
//                .overridingErrorMessage("Error code is not as expected. Error code is - " + actualErrorCode)
//                .isEqualTo(errorCode);
//    }
//
//    @And("^ResponseEndpoint tries send OrderResponse to OM more than 1 time$")
//    public void responseWasStoredIntoHistoryDB() throws InterruptedException {
////    Thread.sleep(2000); // Elasticsearch index time
////    List<History> history = dbHelper.getHistory(OrderNo.getOrderNo());
////    assertThat(history.length()).isGreaterThan(historyStateBefore).overridingErrorMessage(String.format("There were no records for order number %s", OrderNo.getOrderNo()));
////    assertThat(history.length()).isGreaterThan(1);
//        //TODO
//        // FIXME: co to?
//    }
//
//    @And("^Response was stored into HistoryDB with (.*) status$")
//    public void responseWasStoredIntoHistoryDB(String status) throws InterruptedException {
////    Thread.sleep(2000); // Elasticsearch index time
////    List<History> history = dbHelper.getHistory(OrderNo.getOrderNo());
////    assertThat(history.map(History::getOrderStatus).toList()).contains(status);
//        //TODO
//        // FIXME: co to? zostawiamy / usuwamy?
//    }
//
//    @And("^Request was stored into HistoryDB with (.*) status$")
//    public void requestWasStoredIntoHistoryDB(String status) throws InterruptedException {
////    Thread.sleep(2000);
////    List<History> history = dbHelper.getHistory(requestId);
////    assertThat(history.length()).isGreaterThan(historyStateBefore).overridingErrorMessage(String.format("There were no records for order number %s", OrderNo.getOrderNo()));
////    assertThat(history.map(History::getOrderStatus).toList()).contains(status);
//        //TODO
//        // FIXME: co to? zostawiamy / usuwamy?
//    }
//
//
//    @And("^Order was stored into HistoryDB with (.*) status$")
//    public void orderWasStoredIntoHistoryDB(OrderStatus status) throws InterruptedException {
//        await()
//                .atMost(15, SECONDS)
//                .until(() ->
//                        orderLogService
//                                .findLogs(requestId)
//                                .map(OrderHistoryLog::getOrderStatus)
//                                .contains(status)
//                );
//    }
//
//    @And("^Order was stored into HistoryDB with (.*) response-status$")
//    public void orderWasStoredIntoHistoryDBresponse(String responseStatus) throws Exception {
//
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                List<OrderHistoryLog> orderHistoryLogs = orderLogService.findLogs(requestId);
//                return orderHistoryLogs.map(OrderHistoryLog::getOrderResponseStatus).map(Enum::toString).contains(responseStatus);
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Could not find response status [%s] in HistoryDB in [%s] sec.", responseStatus, timeout / 1000));
//    }
//
//    @And("^Order was stored into ConnectDB$")
//    public void orderWasStoredIntoConnectDB() throws InterruptedException {
//        await()
//                .atMost(15, SECONDS)
//                .until(() -> orderStatusService.findByRequestId(requestId).isDefined());
//    }
//
//    @And("^Order was stored into ConnectDB with (.*) status$")
//    public void orderWasStoredIntoConnectDBStatus(OrderStatus status) throws Exception {
//        await()
//                .atMost(15, SECONDS)
//                .until(() -> orderStatusService.findByRequestId(requestId).map(OrderStatusRecord::getOrderStatus).contains(status));
//    }
//
//    @And("^Callback attempts was stored into HistoryDB with (.*) status$")
//    public void CallbackAttemptsWasStoredIntoHistoryDB(String status) throws InterruptedException {
////    Thread.sleep(2000); // wait for ES data indexing
////    List<History> history = dbHelper.getHistory(OrderNo.getOrderNo());
////    assertThat(history.length() > historyStateBefore).overridingErrorMessage(String.format("There were no records for order number %s", OrderNo.getOrderNo()));
////    assertThat(history.map(History::getOrderStatus).toList()).contains(status);
////    assertThat(history.filter(h -> h.getPayload().contains("orderCallback")).size()).isGreaterThan(0);
//        //TODO
//        // FIXME: co to? zostawiamy / usuwamy?
//    }
//
//
//    @SneakyThrows
//    @Given("^Subscription Data Base state is (.+)(before|after)(| negative)$")
//    public void subscriptionDataBaseStateIsSdbImageBefore(String unformatedFilePath, String state, String type) throws JSONException, UnknownHostException {
//        val filePath = PathFinder.getSdbImageFileLocation(unformatedFilePath + state + type);
//        val jsonFile = new ClassPathResource(filePath);
//        val parser = new JSONParser();
//        val obj = (JSONObject) parser.parse(new FileReader(jsonFile.getFile())); // or new File("src/test/resources/"+filePath).getAbsolutePath()
//        val document = Document.parse(Objects.requireNonNull(obj).toJSONString());
//
//        switch (state) {
//            case "before":
//                sdbMongoService.createConnection(sdbHost, sdbPort, sdbName, sdbCol);
//                sdbMongoService.deleteAll();
//                sdbMongoService.insertData(document);
//                sdbMongoService.closeConnection();
//                break;
//            case "after":
//                httpResponse = sdbApi.sendRequest("http://" + sdbApiUrl + "/", curSubscriptionId, curSubscriptionType);
//                val responseObj = (JSONObject) parser.parse(httpResponse);
//                assertThat(validateSubscription(responseObj, obj)).overridingErrorMessage(format("Actual SDB Image is not equal to expected. Object got from SDB is - \n%s\n" +
//                        ", while expected was - (fields about creating and modyfing are not compared)\n%s", responseObj.toJSONString(), obj.toJSONString())).isEqualTo(true);
//                break;
//        }
//    }
//
//    @Then("^Subscription is searched by MSISDN (\\d+)$")
//    public void subscriptionIsSearchedByMSISND(String MSISDN) {
//        curSubscriptionId = MSISDN;
//    }
//
//    @And("^LDAP was prepared with (.+) command$")
//    public void LDAPPrepare(String unformatedPath) {
//        val formatedPath = PathFinder.getLdifFileLocation(unformatedPath);
//        val filePath = System.getProperty("user.dir") + "/src/test/resources/" + formatedPath;
//        ldapClient = new LDAPClient(ldapHost, ldapPort, ldapLogin, ldapPassword);
//        val ldapService = new LDAPService(ldapClient);
//        val responses = ldapService.processLdif(filePath);
//        for (LDAPResult response : responses) {
//            log.info("Diagnostic message - " + response.getDiagnosticMessage());
//            log.info("Result string      - " + response.getResultString());
//            log.info("Result code        - " + response.getResultCode());
//            log.info("Matched DN         - " + response.getMatchedDN());
//        }
//    }          // dodać asercje ? // FIXME: a dodajemy?
//
//
//    @And("^Task with ordinal (\\d+) on NE_ID (.+) should be created$")
//    public void taskOnNeShouldBeCreated(int ordinal, String neId) throws Exception {
//        taskOnNeShouldBeCreated(ordinal, neId, "0");
//    }
//
//
//    @And("^Rollback task with ordinal (\\d+) on NE_ID (.+) should be created$")
//    public void rollbackTaskOnNeCreated(int ordinal, String neId) throws Exception {
//        taskOnNeShouldBeCreated(ordinal, neId, "1");
//    }
//
//    @And("^Task first log should contain (.+)$")
//    public void taskLogShouldContain(String text) throws Exception {
//        val payload = currentTaskLogs.find(log -> log.getTaskStatus() == TaskStatus.QUEUED).get().getPayload().get();
//        assertThat(payload)
//                .overridingErrorMessage("Task log does not contain - \n" + text + "\n Tasks payload is - \n" + payload)
//                .contains(text);
//    }
//
//    @And("^Task executing log should contain (.+)$")
//    public void taskExecutingLogShouldContain(String text) {
//
//        val currentTasksExecuting = currentTaskLogs.filter(log -> log.getTaskStatus() == TaskStatus.EXECUTING);
//
//        String payloads = currentTasksExecuting
//                .map(log -> log.getPayload().get() + "\n")
//                .foldLeft(new StringBuilder(), StringBuilder::append).toString();
//
//        assertThat(payloads)
//                .overridingErrorMessage("Task log does not contain - \n" + text + "\n Tasks payload is - \n" + payloads)
//                .contains(text);
//    }
//
//    @And("^Task final log should contain (.+)$")
//    public void taskFinalLogShouldContain(String text) throws Exception {
//        val payload = currentTaskLogs.find(log -> log.getTaskStatus() == TaskStatus.FAILED || log.getTaskStatus() == TaskStatus.COMPLETED).get().getPayload().get();
//        assertThat(payload)
//                .overridingErrorMessage("Task log does not contain - \n" + text + "\n Tasks payload is - \n" + payload)
//                .contains(text);
//    }
//
//    @And("^Task first log should not contain (.+)$")
//    public void taskLogShouldNotContain(String text) throws Exception {
//        val payload = currentTaskLogs.find(log -> log.getTaskStatus() == TaskStatus.QUEUED).get().getPayload().get();
//        assertThat(payload).
//                overridingErrorMessage("Task log should not contain - \n" + text + "\n Tasks payload is - \n" + payload)
//                .doesNotContain(text);
//    }
//
//    @And("^Task executing log should not contain (.+)$")
//    public void taskExecutingLogShouldNotContain(String text) throws Exception {
//
//        val currentTasksExecuting = currentTaskLogs.filter(log -> log.getTaskStatus() == TaskStatus.EXECUTING);
//
//        String payloads = currentTasksExecuting
//                .map(log -> log.getPayload().get() + "\n")
//                .foldLeft(new StringBuilder(), StringBuilder::append).toString();
//
//        assertThat(payloads)
//                .overridingErrorMessage("Task log does not contain - \n" + text + "\n Tasks payload is - \n" + payloads)
//                .doesNotContain(text);
//    }
//
//    @And("^Task final log should not contain (.+)$")
//    public void taskFinalLogShouldNotContain(String text) throws Exception {
//        val payload = currentTaskLogs.find(log -> (log.getTaskStatus() == TaskStatus.FAILED || log.getTaskStatus() == TaskStatus.COMPLETED)).get().getPayload().get();
//        assertThat(payload).
//                overridingErrorMessage("Task log does contain - \n" + text + "\n Tasks payload is - \n" + payload)
//                .doesNotContain(text);
//    }
//
//
//    @And("^Task has status (.+)$")
//    public void taskHasSpecifiedStatus(TaskStatus status) throws Exception {
//        assertThat(currentTaskLogs.find(taskLog -> taskLog.getTaskStatus() == status)).isNotEmpty();
//    }
//
//    @And("^OM Callback is set to Resend Mode$")
//    public void omCallbackIsSetToResendMode() throws Exception {
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                callbackResponse = connectCallbackApi.getConnectCallback(callbackConfigureApiUrl + "/resendMode?count=99999999");
//                return callbackResponse.equals("99999999");
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Response: %s, not same as expected: %s, in %s sec.", callbackResponse, "99999999", timeout / 1000));
//    }
//
//    @And("^OM Callback is set to Resend Mode for (\\d+) requests$")
//    public void omCallbackIsSetToResendModeFor(int count) throws Exception {
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                callbackResponse = connectCallbackApi.getConnectCallback(callbackConfigureApiUrl + "/resendMode?count=" + count);
//                return callbackResponse.equals(String.valueOf(count));
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Response: %s, not same as expected: %s, in %s sec.", callbackResponse, count, timeout / 1000));
//    }
//
//    @And("^OM Callback is set to Exception Mode$")
//    public void omCallbackIsSetToExceptionMode() throws Exception {
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                callbackResponse = connectCallbackApi.getConnectCallback(callbackConfigureApiUrl + "/exceptionMode?count=99999999");
//                return callbackResponse.equals("99999999");
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Response: %s, not same as expected: %s, in %s sec.", callbackResponse, "99999999", timeout / 1000));
//    }
//
//    @And("^OM Callback is set to Exception Mode for (\\d+) requests$")
//    public void omCallbackIsSetToExceptionModeFor(int count) throws Exception {
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                callbackResponse = connectCallbackApi.getConnectCallback(callbackConfigureApiUrl + "/exceptionMode?count=" + count);
//                return callbackResponse.equals(String.valueOf(count));
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Response: %s, not same as expected: %s, in %s sec.", callbackResponse, count, timeout / 1000));
//    }
//
//    @And("^OM Callback is set to Standard Mode$")
//    public void omCallbackIsSetToStandardMode() throws Exception {
//        Waiting waiting = new Waiting() {
//            @Override
//            public boolean until() {
//                callbackResponse = connectCallbackApi.getConnectCallback(callbackConfigureApiUrl + "/standardMode");
//                return callbackResponse.equals("OK");
//            }
//        };
//        waiting.waitUntil(timeout, sleep, format("Response: %s, not same as expected: %s, in %s sec.", callbackResponse, "OK", timeout / 1000));
//    }
//
//    @When("^Create order group with id (.+) and value (\\d+)$")
//    public void createOrderGroupWithMSISDN(String name, long value) {
//        requestGroupId = name;
//        requestGroupValue = value;
//        requestGroup = new ArrayList<>();
//    }
//
//    @And("^Add order to group$")
//    public void addOrderToGroup() {
//        requestDataObject = new RequestDataObject();
//        requestGroup.add(requestDataObject);
//        orders++;
//    }
//
//    @And("^Add rfs to order :$")
//    public void addRfsToOrder(DataTable rfsAttributes) {
//        Map<String, String> resources = rfsAttributes.asMap(String.class, String.class);
//        orderDataObject = new OrderDataObject();
//        requestDataObject.appendOrder(orderDataObject);
//        orderDataObject.setAttributes(resources);
//    }
//
//    @And("^Add params to rfs:$")
//    public void addParamsToRfsPerformance(DataTable rfsParams) {
//        orderDataObject.addParams(rfsParams);
//    }
//
//    @And("^Build (\\d+) order groups$")
//    public void buildOrderGroups(int number) {
//        orderGroups = number;
//        long currentSubValue = requestGroupValue;
//        for (int i = 0; i < number; i++) {
//            for (RequestDataObject request : requestGroup) {
//                xmlBuilder.createBasicStructure(connectCallbackUrl, requestSoapUsername, requestSoapPassword);
//                xmlBuilder.addSubscriptionIds(requestGroupId, String.valueOf(currentSubValue));
//                for (OrderDataObject order : request.getOrders()) {
//                    xmlBuilder.addRfs();
//                    for (String key : order.getAttributes().keySet()) {
//                        xmlBuilder.addAttributes(key, order.getAttributes().get(key));
//                    }
//                    for (DataTable params : order.getParams()) {
//                        xmlBuilder.addParams(params);
//                    }
//                }
//                requestsList.add(xmlBuilder.convertToString());
//            }
//            currentSubValue++;
//        }
//    }
//
//
//    @And("^Send orders to converter with (\\d+) threads$")
//    public void sendOrdersToConverter(int numberOfThreads) throws Throwable {
//
//        Runnable[] runners = new Runnable[numberOfThreads];
//        Thread[] threads = new Thread[numberOfThreads];
//        int requestGroupsPerRunner = orderGroups / numberOfThreads;
//        int requestsPerRunner = requestGroupsPerRunner * orders;
//        int unhandledGroups = orderGroups % numberOfThreads;
//        int index = 0;
//
//        for (int i = 0; i < numberOfThreads; i++) {
//            ArrayList<String> requests = new ArrayList<>();
//
//            int requestsPerThisRunner = requestsPerRunner;
//            if (i < unhandledGroups) {
//                requestsPerThisRunner += orders;
//            }
//
//            for (int j = 0; j < requestsPerThisRunner; j++) {
//                requests.add(requestsList.get(index));
//                index += 1;
//            }
//
//            runners[i] = new RequestSender(requests, requestEndpointUrl);
//        }
//
//        for (int i = 0; i < numberOfThreads; i++) {
//            threads[i] = new Thread(runners[i]);
//        }
//
//        for (int i = 0; i < numberOfThreads; i++) {
//            threads[i].start();
//        }
//        for (int i = 0; i < numberOfThreads; i++) {
//            threads[i].join();
//        }
//    }
//
//
//    @When("^Set starting subscription type for (.*) and id for (\\d+)$")
//    public void setStartingSubscription(String type, String id) {
//        curSubscriptionId = id;
//        curSubscriptionType = type;
//    }
//
//    @And("^Set delay for (\\d+) seconds$")
//    public void setDelayForSeconds(int seconds) {
//        longTermTestsDelay = seconds * 1000;
//    }
//
//    @Then("^Tests keep going on$")
//    public void testsKeepGoingOn() throws Exception {
//        while (true) {
//            Thread.sleep(longTermTestsDelay);
//
//            xmlBuilder.createBasicStructure(connectCallbackUrl, requestSoapUsername, requestSoapPassword);
//            xmlBuilder.addSubscriptionIds(curSubscriptionType, curSubscriptionId);
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voice-voip");
//            xmlBuilder.addAttributes("action", "ACTIVATE");
//
//            HashMap<String, String> params = new HashMap<>();
//            params.put("passcode", "5YGH!g0e2n!%");
//            params.put("local-info", "1465058");
//
//            xmlBuilder.addParams(params);
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-call-wait");
//            xmlBuilder.addAttributes("action", "ACTIVATE");
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-call-hold");
//            xmlBuilder.addAttributes("action", "ACTIVATE");
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-voice-mail");
//            xmlBuilder.addAttributes("action", "ACTIVATE");
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-premium-barrings");
//            xmlBuilder.addAttributes("action", "ACTIVATE");
//
//
//            log.info("Prepared Activate Standalone Voip order with {} {}, now sending..", curSubscriptionType, curSubscriptionId);
//            soapResponse = requestService.send(xmlBuilder.convertToString(), new URL(requestEndpointUrl));
//            log.info("Soap response is - {}", soapResponse);
//
//
//            xmlBuilder.createBasicStructure(connectCallbackUrl, requestSoapUsername, requestSoapPassword);
//            xmlBuilder.addSubscriptionIds(curSubscriptionType, curSubscriptionId);
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voice-voip");
//            xmlBuilder.addAttributes("action", "DEACTIVATE");
//
//            params = new HashMap<>();
//            params.put("passcode", "5YGH!g0e2n!%");
//            params.put("local-info", "1465058");
//
//            xmlBuilder.addParams(params);
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-call-wait");
//            xmlBuilder.addAttributes("action", "DEACTIVATE");
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-call-hold");
//            xmlBuilder.addAttributes("action", "DEACTIVATE");
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-voice-mail");
//            xmlBuilder.addAttributes("action", "DEACTIVATE");
//
//            xmlBuilder.addRfs();
//            xmlBuilder.addAttributes("rfsId", "voip-premium-barrings");
//            xmlBuilder.addAttributes("action", "DEACTIVATE");
//
//
//            log.info("Prepared Deactivate Standalone Voip order with {} {}, now sending..", curSubscriptionType, curSubscriptionId);
//            soapResponse = requestService.send(xmlBuilder.convertToString(), new URL(requestEndpointUrl));
//            log.info("Soap response is - {}", soapResponse);
//
//            curSubscriptionId = String.valueOf(Long.parseLong(curSubscriptionId) + 1);
//        }
//    }
//
//
//    private void taskOnNeShouldBeCreated(int ordinal, String neId, String taskIdPattern) throws Exception {
//
//
//        await()
//                .atMost(2, SECONDS)
//                .until(() -> {
//                    val requestTasksLogs = taskLogService.findLogs(requestId);
//
//                    if (requestTasksLogs.isEmpty()) return false;
//
//                    val selectedTaskLogs = requestTasksLogs
//                            .filter(order -> order.getOrdinal() == ordinal && order.getTaskId().matches("(.*):(.+):" + taskIdPattern + ":(.*)"));
//
//                    if (selectedTaskLogs.isEmpty()) return false;
//
//                    val queuedTaskLogOpt = selectedTaskLogs.find(taskLog -> taskLog.getTaskStatus() == TaskStatus.QUEUED);
//
//                    if (queuedTaskLogOpt.isEmpty()) return false;
//
//                    val queuedTaskLog = queuedTaskLogOpt.get();
//
//                    return queuedTaskLogOpt.isEmpty();
//                });
//
//
//        val requestTasksLogs = taskLogService.findLogs(requestId);
//        assertThat(requestTasksLogs)
//                .withFailMessage("No task logs for this request have been found")
//                .isNotEmpty();
//
//        val selectedTaskLogs = requestTasksLogs
//                .filter(order -> order.getOrdinal() == ordinal && order.getTaskId().matches("(.*):(.+):" + taskIdPattern + ":(.*)"));
//
//        assertThat(selectedTaskLogs)
//                .withFailMessage("Ordinal [%d] does not match.", ordinal)
//                .isNotEmpty();
//
//        val queuedTaskLogOpt = selectedTaskLogs.find(taskLog -> taskLog.getTaskStatus() == TaskStatus.QUEUED);
//        assertThat(queuedTaskLogOpt)
//                .withFailMessage("Task log with status [%s] not found.", TaskStatus.QUEUED)
//                .isNotEmpty();
//
//        val queuedTaskLog = queuedTaskLogOpt.get();
//        val queuedTaskLogNeId = queuedTaskLog.getNeId();
//        assertThat(queuedTaskLogNeId)
//                .withFailMessage("NE_ID [%s] is different than expected [%s].", queuedTaskLogNeId, neId)
//                .isEqualTo(neId);
//
//        currentTaskLogs = selectedTaskLogs;
//    }
//
//
//    private boolean validateSubscription(JSONObject json1, JSONObject json2) {
//
//        String jsonString1 = json1.toJSONString();
//        String jsonString2 = json2.toJSONString();
//        String flag = "1";
//        try {
//            ReducedSubscription subscription1 = objectMapper.readValue(jsonString1, ReducedSubscription.class);
//            flag = "2";
//            ReducedSubscription subscription2 = objectMapper.readValue(jsonString2, ReducedSubscription.class);
//            return subscription1.equals(subscription2);
//        } catch (Exception e) {
//            if (flag.equals("1")) {
//                log.info("1 - Exception trying to map \n\n {} \n\n to the ReducedSubscription class. Exception message is {}", jsonString1, e.getMessage());
//            } else {
//                log.info("2 - Exception trying to map \n\n {} \n\n to the ReducedSubscription class. Exception message is {}", jsonString2, e.getMessage());
//            }
//            return false;
//        }
//    }
//
//
//    @And("^Request is saved$")
//    public void requestIsSaved() throws Exception {
//        xmlBuilder.saveDocument();
//    }
}