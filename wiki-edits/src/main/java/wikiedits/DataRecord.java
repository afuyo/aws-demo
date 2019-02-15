package wikiedits; /**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DataRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2718704431028298529L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DataRecord\",\"fields\":[{\"name\":\"data\",\"type\":{\"type\":\"record\",\"name\":\"Data\",\"fields\":[{\"name\":\"FF_NR\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"FORNAVN\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"EFTERNAVN\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_NR\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"M_K_KODE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"FOEDSELSDATO\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"FOEDSDAT_AENDR_DOK\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"PERSON_STATUS_DATO\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"PERSON_STATUS\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"PERSON_STATUS_DOK\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_DATA_FORSKEL\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_ADR_OPD\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_FORNAVN_OPD\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_EFTERNAVN_OPD\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_NR_OPLYST_KODE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"CPR_NR_AENDR_DOK\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"KALDE_FORNAVN_MRK\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"TJM_KODE\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"STILLING_DATO\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"RET_SBH\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"RET_TIMESTAMP\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"STILLING\",\"type\":[\"null\",\"string\"],\"default\":null}]}},{\"name\":\"beforeData\",\"type\":[\"null\",\"Data\"],\"default\":null},{\"name\":\"headers\",\"type\":{\"type\":\"record\",\"name\":\"Headers\",\"fields\":[{\"name\":\"operation\",\"type\":{\"type\":\"enum\",\"name\":\"operation\",\"symbols\":[\"INSERT\",\"UPDATE\",\"DELETE\",\"REFRESH\"]}},{\"name\":\"changeSequence\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"string\"},{\"name\":\"streamPosition\",\"type\":\"string\"},{\"name\":\"transactionId\",\"type\":\"string\"},{\"name\":\"changeMask\",\"type\":[\"null\",\"bytes\"]},{\"name\":\"columnMask\",\"type\":[\"null\",\"bytes\"]},{\"name\":\"externalSchemaId\",\"type\":[\"null\",\"string\"],\"default\":null}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public Data data;
  @Deprecated public Data beforeData;
  @Deprecated public Headers headers;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public DataRecord() {}

  /**
   * All-args constructor.
   * @param data The new value for data
   * @param beforeData The new value for beforeData
   * @param headers The new value for headers
   */
  public DataRecord(Data data, Data beforeData, Headers headers) {
    this.data = data;
    this.beforeData = beforeData;
    this.headers = headers;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return data;
    case 1: return beforeData;
    case 2: return headers;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: data = (Data)value$; break;
    case 1: beforeData = (Data)value$; break;
    case 2: headers = (Headers)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'data' field.
   * @return The value of the 'data' field.
   */
  public Data getData() {
    return data;
  }

  /**
   * Sets the value of the 'data' field.
   * @param value the value to set.
   */
  public void setData(Data value) {
    this.data = value;
  }

  /**
   * Gets the value of the 'beforeData' field.
   * @return The value of the 'beforeData' field.
   */
  public Data getBeforeData() {
    return beforeData;
  }

  /**
   * Sets the value of the 'beforeData' field.
   * @param value the value to set.
   */
  public void setBeforeData(Data value) {
    this.beforeData = value;
  }

  /**
   * Gets the value of the 'headers' field.
   * @return The value of the 'headers' field.
   */
  public Headers getHeaders() {
    return headers;
  }

  /**
   * Sets the value of the 'headers' field.
   * @param value the value to set.
   */
  public void setHeaders(Headers value) {
    this.headers = value;
  }

  /**
   * Creates a new DataRecord RecordBuilder.
   * @return A new DataRecord RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new DataRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DataRecord RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new DataRecord RecordBuilder by copying an existing DataRecord instance.
   * @param other The existing instance to copy.
   * @return A new DataRecord RecordBuilder
   */
  public static Builder newBuilder(DataRecord other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for DataRecord instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DataRecord>
    implements org.apache.avro.data.RecordBuilder<DataRecord> {

    private Data data;
    private Data.Builder dataBuilder;
    private Data beforeData;
    private Data.Builder beforeDataBuilder;
    private Headers headers;
    private Headers.Builder headersBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.data)) {
        this.data = data().deepCopy(fields()[0].schema(), other.data);
        fieldSetFlags()[0] = true;
      }
      if (other.hasDataBuilder()) {
        this.dataBuilder = Data.newBuilder(other.getDataBuilder());
      }
      if (isValidValue(fields()[1], other.beforeData)) {
        this.beforeData = data().deepCopy(fields()[1].schema(), other.beforeData);
        fieldSetFlags()[1] = true;
      }
      if (other.hasBeforeDataBuilder()) {
        this.beforeDataBuilder = Data.newBuilder(other.getBeforeDataBuilder());
      }
      if (isValidValue(fields()[2], other.headers)) {
        this.headers = data().deepCopy(fields()[2].schema(), other.headers);
        fieldSetFlags()[2] = true;
      }
      if (other.hasHeadersBuilder()) {
        this.headersBuilder = Headers.newBuilder(other.getHeadersBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing DataRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(DataRecord other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.data)) {
        this.data = data().deepCopy(fields()[0].schema(), other.data);
        fieldSetFlags()[0] = true;
      }
      this.dataBuilder = null;
      if (isValidValue(fields()[1], other.beforeData)) {
        this.beforeData = data().deepCopy(fields()[1].schema(), other.beforeData);
        fieldSetFlags()[1] = true;
      }
      this.beforeDataBuilder = null;
      if (isValidValue(fields()[2], other.headers)) {
        this.headers = data().deepCopy(fields()[2].schema(), other.headers);
        fieldSetFlags()[2] = true;
      }
      this.headersBuilder = null;
    }

    /**
      * Gets the value of the 'data' field.
      * @return The value.
      */
    public Data getData() {
      return data;
    }

    /**
      * Sets the value of the 'data' field.
      * @param value The value of 'data'.
      * @return This builder.
      */
    public Builder setData(Data value) {
      validate(fields()[0], value);
      this.dataBuilder = null;
      this.data = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'data' field has been set.
      * @return True if the 'data' field has been set, false otherwise.
      */
    public boolean hasData() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'data' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Data.Builder getDataBuilder() {
      if (dataBuilder == null) {
        if (hasData()) {
          setDataBuilder(Data.newBuilder(data));
        } else {
          setDataBuilder(Data.newBuilder());
        }
      }
      return dataBuilder;
    }

    /**
     * Sets the Builder instance for the 'data' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public Builder setDataBuilder(Data.Builder value) {
      clearData();
      dataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'data' field has an active Builder instance
     * @return True if the 'data' field has an active Builder instance
     */
    public boolean hasDataBuilder() {
      return dataBuilder != null;
    }

    /**
      * Clears the value of the 'data' field.
      * @return This builder.
      */
    public Builder clearData() {
      data = null;
      dataBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'beforeData' field.
      * @return The value.
      */
    public Data getBeforeData() {
      return beforeData;
    }

    /**
      * Sets the value of the 'beforeData' field.
      * @param value The value of 'beforeData'.
      * @return This builder.
      */
    public Builder setBeforeData(Data value) {
      validate(fields()[1], value);
      this.beforeDataBuilder = null;
      this.beforeData = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'beforeData' field has been set.
      * @return True if the 'beforeData' field has been set, false otherwise.
      */
    public boolean hasBeforeData() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'beforeData' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Data.Builder getBeforeDataBuilder() {
      if (beforeDataBuilder == null) {
        if (hasBeforeData()) {
          setBeforeDataBuilder(Data.newBuilder(beforeData));
        } else {
          setBeforeDataBuilder(Data.newBuilder());
        }
      }
      return beforeDataBuilder;
    }

    /**
     * Sets the Builder instance for the 'beforeData' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public Builder setBeforeDataBuilder(Data.Builder value) {
      clearBeforeData();
      beforeDataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'beforeData' field has an active Builder instance
     * @return True if the 'beforeData' field has an active Builder instance
     */
    public boolean hasBeforeDataBuilder() {
      return beforeDataBuilder != null;
    }

    /**
      * Clears the value of the 'beforeData' field.
      * @return This builder.
      */
    public Builder clearBeforeData() {
      beforeData = null;
      beforeDataBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'headers' field.
      * @return The value.
      */
    public Headers getHeaders() {
      return headers;
    }

    /**
      * Sets the value of the 'headers' field.
      * @param value The value of 'headers'.
      * @return This builder.
      */
    public Builder setHeaders(Headers value) {
      validate(fields()[2], value);
      this.headersBuilder = null;
      this.headers = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'headers' field has been set.
      * @return True if the 'headers' field has been set, false otherwise.
      */
    public boolean hasHeaders() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'headers' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Headers.Builder getHeadersBuilder() {
      if (headersBuilder == null) {
        if (hasHeaders()) {
          setHeadersBuilder(Headers.newBuilder(headers));
        } else {
          setHeadersBuilder(Headers.newBuilder());
        }
      }
      return headersBuilder;
    }

    /**
     * Sets the Builder instance for the 'headers' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public Builder setHeadersBuilder(Headers.Builder value) {
      clearHeaders();
      headersBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'headers' field has an active Builder instance
     * @return True if the 'headers' field has an active Builder instance
     */
    public boolean hasHeadersBuilder() {
      return headersBuilder != null;
    }

    /**
      * Clears the value of the 'headers' field.
      * @return This builder.
      */
    public Builder clearHeaders() {
      headers = null;
      headersBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public DataRecord build() {
      try {
        DataRecord record = new DataRecord();
        if (dataBuilder != null) {
          record.data = this.dataBuilder.build();
        } else {
          record.data = fieldSetFlags()[0] ? this.data : (Data) defaultValue(fields()[0]);
        }
        if (beforeDataBuilder != null) {
          record.beforeData = this.beforeDataBuilder.build();
        } else {
          record.beforeData = fieldSetFlags()[1] ? this.beforeData : (Data) defaultValue(fields()[1]);
        }
        if (headersBuilder != null) {
          record.headers = this.headersBuilder.build();
        } else {
          record.headers = fieldSetFlags()[2] ? this.headers : (Headers) defaultValue(fields()[2]);
        }
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
