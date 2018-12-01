@Bank
@All
Feature: BankFeature

  @Transfer
  Scenario: Bank Transfer
    Given Create bank with name Amigos
    And Add account with name: 2002 ownerName: Brajan balance: 1000
    And Add account with name: 2003 ownerName: Dżesika balance: 1500
    When Transfer 200 zł from 2002 to 2003
    Then Account 2002 has balance: 800
    Then Account 2003 has balance: 1700

#    And LDAP was prepared with barring eighteen - activate - delete subscription command
#    And LDAP was prepared with barring eighteen - activate - create subscription command
#    When Create a soap request
#    And Add subscription id MSISDN with value 48257533414
#    And Add rfs with attributes:
#      | rfsId  | voip-barring-eighteen |
#      | action | ACTIVATE              |
#    When Soap request is sent to request endpoint
#    Then Request is ACK'ed by Request Endpoint
#    And Order was stored into HistoryDB with RECEIVED status
#    And Order was stored into ConnectDB
#    When Response was consumed from Queue by ResponseEndpoint and sent to OM callback
#    Then OM callback receives OrderResponse with no errors
#    And Subscription Data Base state is barring eighteen - activate - sdb image after
#    And Order was stored into ConnectDB with COMPLETED status
#    And Order was stored into HistoryDB with QUEUED status
#    And Order was stored into HistoryDB with EXECUTING status
#    And Order was stored into HistoryDB with COMPLETED status
#    And Task with ordinal 0 on NE_ID MSDR_A should be created
#    And Task has status COMPLETED
#    And Task first log should not contain "code":400
#    And Task first log should contain "item-id":"msdr-modify-object-template"
#    And Task first log should contain {"id":"msisdn","value":"48257533414"}
#    And Task executing log should contain dn: uid=48257533414,ou=subscribers,ou=sdr,o=ptc.com.pl
#    And Task executing log should contain changetype: modify
#    And Task executing log should contain add: objectClass
#    And Task executing log should contain objectClass: ptcMinorsProtSubscriber
#    And Task executing log should contain replace: MinorsProtServiceStatus
#    And Task executing log should contain MinorsProtServiceStatus: TRUE
#    And Task executing log should contain replace: ssmsPrbServiceRespMsgActive
#    And Task executing log should contain ssmsPrbServiceRespMsgActive: TRUE
#    And Task executing log should contain replace: ssmsPrbServiceRespMsgId
#    And Task executing log should contain ssmsPrbServiceRespMsgId: 11
#    And Task executing log should not contain exception
#    And Task final log should contain "rollback":false
#
#
#
#  @Deactivate
#  Scenario: BarringEighteen deactivate
#    Given Subscription Data Base state is barring eighteen - deactivate - sdb image before
#    When Create a soap request
#    And Add subscription id MSISDN with value 48257533414
#    And Add rfs with attributes:
#      | rfsId  | voip-barring-eighteen |
#      | action | DEACTIVATE            |
#    When Soap request is sent to request endpoint
#    Then Request is ACK'ed by Request Endpoint
#    And Order was stored into HistoryDB with RECEIVED status
#    And Order was stored into ConnectDB
#    When Response was consumed from Queue by ResponseEndpoint and sent to OM callback
#    Then OM callback receives OrderResponse with no errors
#    And Subscription Data Base state is barring eighteen - deactivate - sdb image after
#    And Order was stored into ConnectDB with COMPLETED status
#    And Order was stored into HistoryDB with QUEUED status
#    And Order was stored into HistoryDB with EXECUTING status
#    And Order was stored into HistoryDB with COMPLETED status
#    And Task with ordinal 0 on NE_ID MSDR_A should be created
#    And Task has status COMPLETED
#    And Task first log should not contain "code":400
#    And Task first log should contain "item-id":"msdr-modify-object-template"
#    And Task first log should contain {"id":"msisdn","value":"48257533414"}
#    And Task executing log should contain dn: uid=48257533414,ou=subscribers,ou=sdr,o=ptc.com.pl
#    And Task executing log should contain changetype: modify
#    And Task executing log should contain delete: objectClass
#    And Task executing log should contain objectClass: ptcMinorsProtSubscriber
#    And Task executing log should contain delete: MinorsProtServiceStatus
#    And Task executing log should contain delete: ssmsPrbServiceRespMsgActive
#    And Task executing log should contain delete: ssmsPrbServiceRespMsgId
#    And Task executing log should not contain exception
#    And Task final log should contain "rollback":false